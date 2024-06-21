package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try {


        Socket socket = new Socket("localhost" ,11112);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream() , true);

        Scanner scanner = new Scanner(System.in);
        System.out.println("chose sign");
        String operatie = scanner.next();
        System.out.println("Add first number");
        int firstNumber = scanner.nextInt();
        System.out.println("Add secound number");
        int secondNumber = scanner.nextInt();
        out.println(operatie);
        out.println(firstNumber);
        out.println(secondNumber);

        String resp = in.readLine();
        System.out.println("The result " + resp);

        socket.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
