package com.raven.cipher;


import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSA {
	
	private PublicKey publicKey;
	private PrivateKey privateKey;
	public void generatorPairKey() {
		SecureRandom sr = new SecureRandom();
		// Thuật toán phát sinh khóa - RSA
		// Độ dài khóa 1024(bits), độ dài khóa này quyết định đến độ an toàn của khóa, càng lớn thì càng an toàn
		// Demo chỉ sử dụng 1024 bit. Nhưng theo khuyến cáo thì độ dài khóa nên tối thiểu là 2048
		KeyPairGenerator kpg;
		try {
			kpg = KeyPairGenerator.getInstance("RSA");
			kpg.initialize(1024, sr);
			// Khởi tạo cặp khóa
			KeyPair kp = kpg.genKeyPair();
			// PublicKey
			publicKey = kp.getPublic();
			// PrivateKey
			privateKey = kp.getPrivate();
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			System.out.println("Lỗi tạo khoá");
		}
		
	}
	public static PublicKey getPublickey(String base64PublicKey) {
		PublicKey pubKey = null;
		try {
			// Tạo public key
			X509EncodedKeySpec spec = new X509EncodedKeySpec(Base64.getDecoder().decode(base64PublicKey.getBytes(StandardCharsets.UTF_8)));
			KeyFactory factory = KeyFactory.getInstance("RSA");
			 pubKey = factory.generatePublic(spec);

			return pubKey;
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lỗi tạo public key");
		}
		return pubKey;
	}
	  public static byte[] encrypt(String data, String publicKey) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException {
	        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
	        cipher.init(Cipher.ENCRYPT_MODE, getPublickey(publicKey));
	        return cipher.doFinal(data.getBytes());
	    }
	public PublicKey getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(PublicKey publicKey) {
		this.publicKey = publicKey;
	}
	public PrivateKey getPrivateKey() {
		return privateKey;
	}
	public void setPrivateKey(PrivateKey privateKey) {
		this.privateKey = privateKey;
	}
	public static PrivateKey getPrivateKey(String base64PrivateKey){
        PrivateKey privateKey = null;
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(base64PrivateKey.getBytes()));
        KeyFactory keyFactory = null;
        try {
            keyFactory = KeyFactory.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
           System.out.println("Lỗi KeyFactory");
        }
        try {
            privateKey = keyFactory.generatePrivate(keySpec);
        } catch (InvalidKeySpecException e) {
            System.out.println("Lỗi tạo privateKey");
        }
        return privateKey;
    }

    public static String decrypt(byte[] data, PrivateKey privateKey) 
    		throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(cipher.doFinal(data));
    }
	public static String decrypt(String data, String base64PrivateKey) throws 
	IllegalBlockSizeException, InvalidKeyException, BadPaddingException
	, NoSuchAlgorithmException, NoSuchPaddingException 
	{
        return decrypt(Base64.getDecoder().decode(data.getBytes()), getPrivateKey(base64PrivateKey));
    }
}
