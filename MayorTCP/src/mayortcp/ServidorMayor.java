/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mayortcp;

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
public class ServidorMayor {

    public static void main(String[] args) {
        int port = 5010;

        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Se inicio el servidor con éxito");

            Socket client;
            PrintStream toClient;
            while (true) {
                client = server.accept(); //conexion
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                System.out.println("Cliente se conecto");
                String cadena=fromClient.readLine();
                String [] valores=cadena.split("-");
                int a=Integer.valueOf(valores[0]);
                int b=Integer.valueOf(valores[1]);
                int mayor=a;
                if (b>a)
                {
                 mayor=b;
                }
                
                toClient = new PrintStream(client.getOutputStream());
                toClient.println(mayor);
                System.out.println("Cliente se conecto");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
