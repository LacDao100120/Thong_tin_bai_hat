/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.client;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author Win 10
 */
public class Client {

    private static Socket socket = null;
    private static BufferedReader in = null;
    private static BufferedWriter out = null;
    private static BufferedReader stdIn = null;

    public static void main(String[] args) {
        try {
            socket = new Socket("localhost", 5000);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            stdIn = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                // Client nhận dữ liệu từ keyboard và gửi vào stream -> server
                System.out.print("Client input: ");
                String line = stdIn.readLine();
                out.write(line);
                out.newLine();
                out.flush();
                if (line.equals("bye")) {
                    break;
                }
                // Client nhận phản hồi từ server
                do {
                    line = in.readLine();
                    System.out.println(line);
                    if (line.isEmpty()) {
                        break;
                    }
                } while (line != null);

            }
            System.out.println("Client closed connection");
            in.close();
            out.close();
            stdIn.close();
            socket.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
