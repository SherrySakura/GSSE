package com.yassna;


import com.yassna.keygen.AESCBC128;
import com.yassna.keygen.RSA;

import javax.crypto.SecretKey;

import static com.yassna.utils.GenerateUtils.byteToHexString;

public class Main {

    public static void main(String[] args) {
        // write your code here

        SecretKey sKey1 = AESCBC128.keyGen(128);
        SecretKey sKey2 = AESCBC128.keyGen(128);
        SecretKey sKey3 = AESCBC128.keyGen(128);
        byte[] b1 = sKey1.getEncoded();
        byte[] b2 = sKey2.getEncoded();
        byte[] b3 = sKey3.getEncoded();
        System.out.println(byteToHexString(b1));
        System.out.println(byteToHexString(b2));
        System.out.println(byteToHexString(b3));
        //RSA.keyGen(1024, "RSA");
        RSA.printKey(RSA.getKey("publicKey.key"));
        RSA.printKey(RSA.getKey("privateKey.key"));
    }
}
