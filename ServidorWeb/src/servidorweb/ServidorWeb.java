/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorweb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Carlos
 */
public class ServidorWeb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int port = 80;
       
            try {
                ServerSocket server = new ServerSocket(port);
                System.out.println("Se inicio el servidor");
                Socket client;
                PrintStream toClient;
                client = server.accept(); //conexion
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                System.out.println("Cliente se conecto");
                String a=fromClient.readLine();
                while (a.length()>0)
                {
                System.out.println(a);
                a=fromClient.readLine();
                }
                toClient = new PrintStream(client.getOutputStream());
                toClient.println("Respuesta");
                
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
    }
    
}
