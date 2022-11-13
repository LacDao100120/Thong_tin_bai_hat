/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tttbh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Win 10
 * Step
 * build get api(connect zing mp3,getResponse,get song )
 * build rsa encrypt
 * build interface
 * connect interface vs server 
 * 
 * 
 */
public class server2 {

    private static ServerSocket server = null;
    private static Socket socket = null;
    private static BufferedReader in = null;
    private static BufferedWriter out = null;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(5000);
            System.out.println("Server started...");
            socket = server.accept();
            System.out.println("Client connected...");
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String result = "";
            while (true) {
                // Server nhận dữ liệu từ client qua stream
                String line = in.readLine();
                if (line.equals("bye")) {
                    break;
                }
                System.out.println("Server get: " + line);
                try {
                    List<String> listResult = getContent(line);
                    result = format(listResult);
                } catch (Exception ex) {
//                    Logger.getLogger(server1.class.getName()).log(Level.SEVERE, null, ex);
                    result = "Không có kết quả\n";
                }
                out.write(result);
                out.newLine(); //newline ở đây là xuống dòng
                out.flush();
            }
            System.out.println("Server closed connection");
            in.close();
            out.close();
            socket.close();
            server.close();

        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    private static List<String> getContent(String cmnd) throws Exception {
        URL hh = new URL("https://masothue.com/Search/?q=" + cmnd + "&type=auto&token=UyZElnG1te&force-search=1");
        URLConnection connection = hh.openConnection();
        String redirect = connection.getHeaderField("Location");
        if (redirect != null) {
            connection = new URL(redirect).openConnection();
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;

        Pattern name = Pattern.compile("<h1 class='h1'>.*?</h1>", Pattern.CASE_INSENSITIVE);
        Pattern detail_1 = Pattern.compile("<span class='copy'>.*?", Pattern.CASE_INSENSITIVE);
        Pattern detail_2 = Pattern.compile("<td>.*?</td>", Pattern.CASE_INSENSITIVE);

        Matcher matcher;
        Matcher matcher1;
        Matcher matcher2;
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        while ((inputLine = in.readLine()) != null) {
            matcher = detail_1.matcher(inputLine);
            matcher1 = detail_2.matcher(inputLine);

            boolean matchFound = matcher.find();
            boolean matchFound1 = matcher1.find();

            if (matchFound) {
                inputLine = inputLine.replaceAll("<.*?>", "");
                inputLine = inputLine.trim();
//                System.out.println("matcher: " +inputLine);
                map.putIfAbsent(inputLine, inputLine);

            }
            if (matchFound1) {
                inputLine = inputLine.replaceAll("<.*?>", "");
                inputLine = inputLine.replaceAll("Ẩn thông tin", "");
                inputLine = inputLine.replaceAll("Ngày hoạt động", "Ngày hoạt động: ");
                inputLine = inputLine.replaceAll("Tình trạng", "Tình trạng: ");
                inputLine = inputLine.trim();
//                System.out.println("matcher 1: " + inputLine);
                map.putIfAbsent(inputLine, inputLine);
            }

        }
        Collection<String> values = map.values();
        List<String> listOfValues = new ArrayList<String>(values);
        listOfValues.remove(6);
        return listOfValues;
    }
    
    public static String format(List list) {
        String result = "";
        String date = (String) list.get(6);
        String status = (String) list.get(9);

        list.remove(6);
        list.remove(8);
        for (int i = 0; i < list.size() / 2; i++) {
            if (i * 2 == 6) {
//                System.out.println(date);
                result += date + "\n";
            }
//            System.out.println(list.get(i * 2) + ": " + list.get(i * 2 + 1));
            result += list.get(i * 2) + ": " + list.get(i * 2 + 1) + "\n";
        }
//        System.out.println(status);
        result += status + "\n";
        
        return result;
    }
}
