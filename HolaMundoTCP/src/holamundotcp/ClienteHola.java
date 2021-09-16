/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holamundotcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;



/**
 *
 * @author Carlos
 */
public class ClienteHola {

    public static void main(String[] args) {
        int port = 5002;
        try {
            Socket client = new Socket("localhost", port); 
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            toServer.println("SIS-258");
            String result = fromServer.readLine();  
            System.out.println("cadena devuelta es: " + result);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
