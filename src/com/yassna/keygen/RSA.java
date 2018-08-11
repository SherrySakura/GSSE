package com.yassna.keygen;

import java.io.*;
import java.security.*;

import static com.yassna.utils.GenerateUtils.byteToHexString;

public class RSA {

    private static final String PUBLICK_KEY_FILE = "publicKey.key";
    private static final String PRIVATE_KEY_FILE = "privateKey.key";

    public static void keyGen(int keyLength, String algorithm){
        SecureRandom random = new SecureRandom();
        ObjectOutputStream oosPublic;
        ObjectOutputStream oosPrivate;
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance(algorithm);
            generator.initialize(keyLength, random);
            KeyPair keyPair = generator.generateKeyPair();
            Key publicKey = keyPair.getPublic();
            Key privateKey = keyPair.getPrivate();

            oosPublic = new ObjectOutputStream(new FileOutputStream(PUBLICK_KEY_FILE));
            oosPrivate = new ObjectOutputStream(new FileOutputStream(PRIVATE_KEY_FILE));
            oosPublic.writeObject(publicKey);
            oosPrivate.writeObject(privateKey);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
        }
    }

    public static Key getKey(String keyFile){
        Key key = null;
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new FileInputStream(keyFile));
            key = (Key)ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return key;
    }

    public static void printKey(Key key){
        byte[] keyByte = key.getEncoded();
        System.out.println("length:" + keyByte.length + " content:" + byteToHexString(keyByte));
    }
}
