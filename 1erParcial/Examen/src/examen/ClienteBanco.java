/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class ClienteBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IBanco banco;
        int idcliente;
        int b;
        Scanner sc=new Scanner(System.in);
        System.out.println("introduzca el idcliente ");
        idcliente =sc.nextInt();
        try {
            banco=(IBanco)Naming.lookup("rmi://localhost/Banco");
            Factura[] facturas=banco.Calcular(idcliente);
            
            String Pago=banco.Pagar(facturas);
            
            System.out.print("?Realizo el pago? Respuesta: "+Pago);
            
        } catch (NotBoundException ex) {
            Logger.getLogger(ClienteBanco.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClienteBanco.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
    }
    
}
