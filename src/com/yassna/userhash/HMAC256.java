package com.yassna.userhash;

import javax.crypto.KeyGenerator;
import java.security.NoSuchAlgorithmException;

public class HMAC256 {
    public static byte[] getHMAC256(){
        try {
            KeyGenerator generator = KeyGenerator.getInstance("HmacSHA256");
            byte[] key = generator.generateKey().getEncoded();
            return key;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
