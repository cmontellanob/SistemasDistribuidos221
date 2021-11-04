/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumirjava;

/**
 *
 * @author Carlos
 */
public class ConsumirJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic her
        int  c=sumar(5,6);
        System.out.println(c);
           int  d=restar(5,6);
        System.out.println(d);
    }

    private static int sumar(int a, int b) {
        servicio.WsOperaciones service = new servicio.WsOperaciones();
        servicio.WsOperacionesSoap port = service.getWsOperacionesSoap12();
        return port.sumar(a, b);
    }

    private static int restar(int a, int b) {
        servicio.WsOperaciones service = new servicio.WsOperaciones();
        servicio.WsOperacionesSoap port = service.getWsOperacionesSoap12();
        return port.restar(a, b);
    }
    
}
