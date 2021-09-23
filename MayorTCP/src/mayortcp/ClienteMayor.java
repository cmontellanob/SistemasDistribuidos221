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
import java.net.Socket;
import java.util.Scanner;



/**
 *
 * @author Carlos
 */
public class ClienteMayor {

    public static void main(String[] args) {
        int port = 5010;
        Scanner sc=new Scanner(System.in); 
        try {
            Socket client = new Socket("localhost", port); 
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println("Introduzca el valore de A");
            int A=sc.nextInt();
            System.out.println("Introduzca el valore de B");
            int B=sc.nextInt();
            
            String cadena;
            cadena=A+"-"+B;
            
            toServer.println(cadena);
            String result = fromServer.readLine();  
            System.out.println("El mayor es: " + result);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
