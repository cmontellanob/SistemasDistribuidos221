/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

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
public class Elapas {

    public static void main(String[] args) {
        int port = 5555;

        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Se inicio el servidor con éxito");

            Socket client;
            PrintStream toClient;
            while (true) {
                client = server.accept(); //conexion
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                System.out.println("Cliente se conecto");
                String cadena = fromClient.readLine();

                toClient = new PrintStream(client.getOutputStream());
                toClient.println(respuesta(cadena));
                System.out.println("Cliente se conecto");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static String respuesta(String cadena) {
        String[] valores = cadena.split("-");
        String respuesta="";
        switch (valores[0]){
            case "fac":
                switch (valores[1])
                {
                    case "1":
                        respuesta="2256-352;3216-263;4547-441";
                    break;
                    case "2":
                        respuesta="1354-215;3252-172";
                        break;
                        
                }
                break;
            case "pag":
                respuesta="SI";
                break; 
                   
                
        }
        
        return respuesta;

    }
}
