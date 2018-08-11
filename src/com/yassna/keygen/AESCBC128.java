package com.yassna.keygen;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class AESCBC128 {

    public static SecretKey keyGen(int length){
        SecretKey sKey = null;
        try {
            KeyGenerator kGen = KeyGenerator.getInstance("AES");
            kGen.init(length);
            sKey = kGen.generateKey();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sKey;
    }
}