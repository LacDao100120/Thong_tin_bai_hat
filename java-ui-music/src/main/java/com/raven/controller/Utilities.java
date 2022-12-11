package com.raven.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.swing.JOptionPane;

import com.raven.cipher.AES;
import com.raven.cipher.RSA;



public class Utilities {
	static BufferedWriter out = null;
    static BufferedReader in = null;
    private static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCgFGVfrY4jQSoZQWWygZ83roKXWD4YeT2x2p41dGkPixe73rT2IW04glagN2vgoZoHuOPqa5and6kAmK2ujmCHu6D1auJhE2tXP+yLkpSiYMQucDKmCsWMnW9XlC5K7OSL77TXXcfvTvyZcjObEz6LIBRzs6+FqpFbUO9SJEfh6wIDAQAB";
    private static RSA rsa;
    private static AES aes;
    public static String getPublicKey() {
		return publicKey;
	}
	public static void setPublicKey(String publicKey) {
		Utilities.publicKey = publicKey;
	}
	private static Socket socket = null;
    private static SecretKey secretKey;
    
    public static Socket ConnectServer(String host, int port) {
        try {
            setSocket(new Socket(host, port));
            rsa = new RSA();
            aes = new AES();
            return getSocket();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "Server is busy right now");
        }
        return null;
    }
    public static String getDecrypt(String encryptString) {
    	return aes.decrypt(encryptString, getSecretKey());
    }
    public void disconnectServer() throws IOException {
        	getSocket().close();
    }
   

    public static Socket getSocket() {
		return socket;
	}
	public static void setSocket(Socket socket) {
		Utilities.socket = socket;
	}
	public static SecretKey getSecretKey() {
		return Utilities.secretKey;
	}
	public static void setSecretKey(SecretKey secretKey) {
		Utilities.secretKey = secretKey;
	}

	//Thực thi gửi request về client
    public static void Reply(String stResult,BufferedWriter out) {
        try {
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            out.write(stResult);
            out.newLine();
            out.flush();
        } catch (IOException ex) {
           System.out.println("Error while reply on Server");
        }
    }
    public static String encrypt(SecretKey key,String text) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, NoSuchAlgorithmException {
    	
        String cipherText1 = Base64.getEncoder().encodeToString(key.getEncoded());
        String RSAEncrypt = Base64.getEncoder().encodeToString(rsa.encrypt(text, publicKey));
		return RSAEncrypt;
    }
    public static RSA getRsa() {
		return rsa;
	}
	public static void setRsa(RSA rsa) {
		Utilities.rsa = rsa;
	}
	public static AES getAes() {
		return Utilities.aes;
	}
	public static void setAes(AES aes) {
		Utilities.aes = aes;
	}
	public static void getPipeLine(Socket socket,BufferedWriter out,BufferedReader in) {
    	if (socket != null && socket.isConnected()) {
            try {
				out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				 in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("error while get connect stream");
			}
           
         } 
    }
    public String Encrypt(String stResult) {
        return aes.encrypt(stResult);
    }
}
