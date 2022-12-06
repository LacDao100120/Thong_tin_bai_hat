package com.raven.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.raven.cipher.AES;
import com.raven.cipher.RSA;
import com.raven.model.Artist;
import com.raven.model.Lyric;
import com.raven.model.Song;
import java.util.HashMap;
import java.util.Map;

 
public class Zingmp3Controller {
	 BufferedWriter out = null;
	 BufferedReader in = null;

	private Socket socket;
	private String host; 
	private int port;
	public JSONConverter converter;
	private  SecretKey secretKey;
	
    public Zingmp3Controller(String host, int port) {
		super();
		this.host = host;
		this.port = port;
		setSocket(Utilities.ConnectServer(host, port));
		converter = new JSONConverter();
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public Zingmp3Controller(Socket socket) {
		this.socket = socket;
	}
	
    public ArrayList<Song> getInfo(String keyword){
//    	Utilities.getPipeLine(socket, out, in);
    	if (socket != null && socket.isConnected()) {
            try {
				out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				 in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				 SecretKey key = Utilities.getAes().generatorKey();
				// Utilities.setSecretKey(key);
				// String text = Utilities.encrypt(key,"newRelease");
				 //secretKey = Utilities.getSecretKey();
				 Utilities.Reply(keyword,out);
			     String line = "";   
				 line = in.readLine();
					Gson gson = new Gson();
					Song[] songs = gson.fromJson(line, Song[].class);
					
					return new ArrayList<Song>(Arrays.asList(songs));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("error while get connect stream");
			
			} 
           
         } 
    	
		return null;
    	 
    }
    public String getSong(String id) {
    	if (socket != null && socket.isConnected()) {
            try {
				out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				 in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				 SecretKey key = Utilities.getAes().generatorKey();
				// Utilities.setSecretKey(key);
				// String text = Utilities.encrypt(key,"newRelease");
				 //secretKey = Utilities.getSecretKey();
				 Utilities.Reply("song;"+id,out);
			     String line = "";   
				 line = in.readLine();
			
					
					return line;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("error while get connect stream");
			
			} 
           
         } 
    	
		return null;
    }
    public ArrayList<Song> searchSong(String keyword){
        Utilities.getPipeLine(socket, out, in);
    	if (socket != null && socket.isConnected()) {
            try {
				out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				 in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				 SecretKey key = Utilities.getAes().generatorKey();
				// Utilities.setSecretKey(key);
				// String text = Utilities.encrypt(key,"newRelease");
				 //secretKey = Utilities.getSecretKey();
				 System.out.println(keyword);
				 Utilities.Reply("keyword;"+keyword,out);
			     String line = "";   
				 line = in.readLine();
					Gson gson = new Gson();
					Song[] songs = gson.fromJson(line, Song[].class);
					
					return new ArrayList<Song>(Arrays.asList(songs));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("error while get connect stream");
			
			} 
           
         } 
    	
		return null;
    }
    public Lyric getLyric(String id){
        Utilities.getPipeLine(socket, out, in);
    	if (socket != null && socket.isConnected()) {
            try {
				out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				 in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				 SecretKey key = Utilities.getAes().generatorKey();
				// Utilities.setSecretKey(key);
				// String text = Utilities.encrypt(key,"newRelease");
				 //secretKey = Utilities.getSecretKey();
				 System.out.println(id);
				 Utilities.Reply("lyric;"+id,out);
			     String line = "";   
				 line = in.readLine();
                                 if(!line.equals("")){
                                     Gson gson = new Gson();
                                     Lyric lyric = gson.fromJson(line, Lyric.class);
                                     return lyric;
                                 }else{
                                     return null;
                                 }
					
					
					
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("error while get connect stream");
			
			} 
           
         } 
    	
		return null;
    }
    public Artist getArtistInfo(String word){
        Utilities.getPipeLine(socket, out, in);
    	if (socket != null && socket.isConnected()) {
            try {
				out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				 in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				 SecretKey key = Utilities.getAes().generatorKey();
				// Utilities.setSecretKey(key);
				// String text = Utilities.encrypt(key,"newRelease");

				 Utilities.Reply("author;"+word,out);
			     String line = "";   
				 line = in.readLine();
                                 if(!line.equals("")){
                                     Gson gson = new Gson();
					Artist artist = gson.fromJson(line, Artist.class);
					
					return artist;
                                 }else{
                                     return null;
                                 }
					
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("error while get connect stream");
			
			} 
           
         } 
    	
		return null;
    }
    public static String deAccent(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD); 
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }
	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
    
}
