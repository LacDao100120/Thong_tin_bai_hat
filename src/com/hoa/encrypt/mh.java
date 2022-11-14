/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package  com.hoa.encrypt;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Formatter;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Admin
 */
public class mh {
    private static final String HMAC_SHA512 = "HmacSHA512";
    private static String toHexString(byte[] bytes) {
    Formatter formatter = new Formatter();
    for (byte b : bytes) {
        formatter.format("%02x", b);
    }
    return formatter.toString();
}

    public static String getSHA256(String input) throws NoSuchAlgorithmException{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(
        input.getBytes(StandardCharsets.UTF_8));
        StringBuilder strBuilder = new StringBuilder(2*encodedhash.length);
        for (int i = 0; i < encodedhash.length; i++) {
        String hex = Integer.toHexString(0xff & encodedhash[i]);
        if(hex.length() == 1) {
            strBuilder.append('0');
        }
        strBuilder.append(hex);
    }
        return strBuilder.toString();
    }

    public static String getHMAC512(String data, String key)
    throws SignatureException, NoSuchAlgorithmException, InvalidKeyException
{
    SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), HMAC_SHA512);
    Mac mac = Mac.getInstance(HMAC_SHA512);
    mac.init(secretKeySpec);
    return toHexString(mac.doFinal(data.getBytes()));
}

}
