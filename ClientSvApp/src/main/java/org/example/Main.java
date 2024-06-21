package org.example;

import java.io.*;
import java.net.*;


public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(11112);
            System.out.println("Server ON");

            while (true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connected");

                BufferedReader add = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String operatie = add.readLine();
              int firstNumber = Integer.parseInt(add.readLine());
              int secondNumber = Integer.parseInt(add.readLine());

                int result;
                switch (operatie) {
                    case "+":
                        result = firstNumber + secondNumber;
                    break;
                    case "-":
                        result = firstNumber - secondNumber;
                    break;
                    case "*":
                        result = firstNumber * secondNumber;
                    break;
                    case "/":
                        result = firstNumber / secondNumber;
                    break;
                        default:
                        out.println("Error");
                        clientSocket.close();
                        continue;

                }

                out.println(" from server is " + result);

                clientSocket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}