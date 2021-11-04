/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Carlos
 */
public interface IBanco extends Remote{
    Factura[] Calcular(int idcliente) throws RemoteException;
    String Pagar (Factura[] facturas) throws RemoteException;
    
}
