/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homamundormi;

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
public class ClienteMensaje {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IMensaje mensaje;
        try {
            mensaje=(IMensaje)Naming.lookup("rmi://localhost/Mensaje");
            
            System.out.print(mensaje.mensaje("Carlos"));
            
            
            
            
        } catch (NotBoundException ex) {
            Logger.getLogger(ClienteMensaje.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClienteMensaje.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteMensaje.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
    }
    
}
