package derschrank.sprint04.task23.bjstwo_51054;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class EncryptionUtils {
    private static SecretKey KEY;

    static {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            KEY = keyGen.generateKey();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("KeyGenerator... " + e);
        }
    }

    public static String encrypt(String message) {
        String encryptedMessage = "* null * error *";
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, KEY);
            byte[] encryptedBytes = cipher.doFinal(message.getBytes());
            encryptedMessage = Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            System.out.println("encrypt... " + e);
        }
        return encryptedMessage;
    }

    public static String decrypt(String encryptedMessage) {
        String decryptedMessage = "* null * error *";
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, KEY);
            byte[] decodedBytes = Base64.getDecoder().decode(encryptedMessage);
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);
            decryptedMessage = new String(decryptedBytes);
        } catch (Exception e) {
            System.out.println("decrypt... " + e);
        }
        return decryptedMessage;
    }
}