/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumirjavac;

/**
 *
 * @author Carlos
 */
public class ConsumirJAVAC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     int c=sumar(4,5);
     System.out.println(c);
    }
    

    private static int sumar(int a, int b) {
        paquete.WsOperaciones_Service service = new paquete.WsOperaciones_Service();
        paquete.WsOperaciones port = service.getWsOperacionesPort();
        return port.sumar(a, b);
    }
    
}
