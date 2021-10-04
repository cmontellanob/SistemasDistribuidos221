/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homamundormi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Carlos
 */
public class ServidorMensaje extends UnicastRemoteObject
        implements IMensaje {

    public ServidorMensaje() throws RemoteException {
        super();
    }
 @Override
    public String mensaje(String nombre)  {
        return "Hola mundo "+nombre;
    }
   
  public static void main(String[] args) {
       ServidorMensaje servidor;  
      try {
	    LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
	    servidor=new ServidorMensaje(); 
	    Naming.bind("Mensaje", servidor); 
            System.out.println("El servidor esta listo\n");
        }
	catch (Exception e){
	    e.printStackTrace();
	}
    }

   
}
