package edu.wfit.hotelmanage.util;

import org.springframework.stereotype.Component;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class PasswordUtil {

    public static String getPasswordBySha256(String password){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] digest = md.digest(password.getBytes());
        BASE64Encoder encoder = new BASE64Encoder();
        String encode = encoder.encode(digest);
        return encode;
    }
}
