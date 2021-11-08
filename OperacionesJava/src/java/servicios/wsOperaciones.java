/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Carlos
 */
@WebService(serviceName = "wsOperaciones")
public class wsOperaciones {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "sumar")
    public int sumar(@WebParam(name = "a") int a,@WebParam(name = "b") int b) {
        return a+b;
    }
        @WebMethod(operationName = "restar")
    public int restar(@WebParam(name = "a") int a,@WebParam(name = "b") int b) {
        return a-b;
    }
        @WebMethod(operationName = "mutiplicar")
    public int multiplicar(@WebParam(name = "a") int a,@WebParam(name = "b") int b) {
        return a*b;
    }
        @WebMethod(operationName = "dividir")
    public int dividir (@WebParam(name = "a") int a,@WebParam(name = "b") int b) {
        return a/b;
    }
}
