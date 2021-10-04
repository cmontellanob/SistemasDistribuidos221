/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operacionesrmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Carlos
 */
public interface IOperaciones  extends Remote {
    int sumar(int a,int b) throws RemoteException;
    int restar(int a,int b)throws RemoteException;
    
}
