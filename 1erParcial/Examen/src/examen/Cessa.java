/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Carlos
 */
public class Cessa extends UnicastRemoteObject implements ICessa {

    public Cessa() throws RemoteException {
        super();
    }

    @Override
    public Factura[] Pendientes(int idcliente) throws RemoteException {
        Factura[] aux=null;
        switch (idcliente) {
            case 1:
                aux=new Factura[2];
                aux[0]=new Factura(Empresa.Cessa, 154, 150);
                aux[1]=new Factura(Empresa.Cessa, 326, 701);
                
                break;
            case 2:
                aux=new Factura[2];
                aux[0]=new Factura(Empresa.Cessa, 325, 610);
                aux[1]=new Factura(Empresa.Cessa, 457, 801);
                break;

        }
        return aux;
        
    }

    @Override
    public boolean pagar(Factura[] facturas) throws RemoteException {
         for (Factura factura:facturas)
         {
             // codigo para actualizar apagado las facturas
         }
         return true;
    }

    public static void main(String[] args) {
        Cessa servidor;
        try {
            LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
            servidor = new Cessa();
            Naming.bind("Cessa", servidor);
            System.out.println("El servidor esta listo\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
