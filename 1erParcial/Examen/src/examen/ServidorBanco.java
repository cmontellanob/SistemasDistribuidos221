/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class ServidorBanco extends UnicastRemoteObject implements IBanco {

    public ServidorBanco() throws RemoteException {
        super();
    }

    @Override
    public Factura[] Calcular(int idcliente) throws RemoteException {
        int port = 5555;
        Factura[] aux = null;
        try {
            // Llamada al servidor CEssa
            ICessa cessa;
            cessa = (ICessa) Naming.lookup("rmi://localhost/Banco");

            Factura[] facturasCessa = cessa.Pendientes(idcliente);
            Factura[] facturasElapas = null;
            // Llamada al servidor Elapas
            Socket client;
            try {
                client = new Socket("localhost", port);
                PrintStream toServer = new PrintStream(client.getOutputStream());
                BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
                toServer.println("fac-" + idcliente);
                String result = fromServer.readLine();
                String[] facturasCadena = result.split(",");
                facturasElapas = new Factura[facturasCadena.length];
                int i = 0;
                for (String facturaCadena : facturasCadena) {
                    String[] datosdactura = facturaCadena.split("-");
                    facturasElapas[i] = new Factura(Empresa.Elapas, Integer.valueOf(datosdactura[0]), Double.valueOf(datosdactura[0]));
                    i++;
                }

            } catch (IOException ex) {
                Logger.getLogger(ServidorBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
            int i = 0;
            aux = new Factura[facturasCessa.length + facturasElapas.length];
            for (Factura factura : facturasCessa) {
                aux[i] = factura;
                i++;
            }
            for (Factura factura : facturasElapas) {
                aux[i] = factura;
                i++;
            }
            return aux;
        } catch (NotBoundException ex) {
            Logger.getLogger(ServidorBanco.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServidorBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aux;
    }

    @Override
    public String Pagar(Factura[] facturas) throws RemoteException {
        try {
            int port = 5555;
            
            Factura[] facturasCessa = obtenerFacturasCessa(facturas);
            
            // Llamada al servidor CEssa
            ICessa cessa;
            cessa = (ICessa) Naming.lookup("rmi://localhost/Banco");
            boolean pago=cessa.pagar(facturasCessa);
            
            Factura[] facturasElapas=obtenerFacturasElapas(facturas);
            String cadena="";
            for(Factura factura:facturasElapas)
            {
                cadena=cadena+factura.idfactura+",";
            }
            cadena=cadena.substring(0, cadena.length()-1);
             Socket client;
            try {
                client = new Socket("localhost", port);
                PrintStream toServer = new PrintStream(client.getOutputStream());
                BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
                toServer.println("pag-" + cadena);
                String result = fromServer.readLine();
                

            } catch (IOException ex) {
                Logger.getLogger(ServidorBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (NotBoundException ex) {
            Logger.getLogger(ServidorBanco.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServidorBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "SI";
    }
    public static Factura[] obtenerFacturasCessa(Factura []facturas)
    {
        int num=0;
        for (Factura factura:facturas)
        {
            if (factura.empresa==Empresa.Cessa)
            {
                num++;
            }
        }
        Factura[] aux =new Factura[num];
        int i=0;
        for (Factura factura:facturas)
        {
            if (factura.empresa==Empresa.Cessa)
            {
                aux[i]=factura;
            }
        }
        return aux;
    }
    public static Factura[] obtenerFacturasElapas(Factura []facturas)
    {
        int num=0;
        for (Factura factura:facturas)
        {
            if (factura.empresa==Empresa.Elapas)
            {
                num++;
            }
        }
        Factura[] aux =new Factura[num];
        int i=0;
        for (Factura factura:facturas)
        {
            if (factura.empresa==Empresa.Elapas)
            {
                aux[i]=factura;
            }
        }
        return aux;
    }

    public static void main(String[] args) {
        ServidorBanco servidor;
        try {
            //  LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
            servidor = new ServidorBanco();
            Naming.bind("Banco", servidor);
            System.out.println("El servidor esta listo\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
