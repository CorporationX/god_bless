package derschrank.sprint04.task23.bjstwo_51054;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Slf4j
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
        String encryptedMessage;
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, KEY);
            byte[] encryptedBytes = cipher.doFinal(message.getBytes());
            encryptedMessage = Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            log.error("Error in encrypt: " + e);
            throw new RuntimeException("Error in encrypt!!!" + e);
        }
        return encryptedMessage;
    }

    public static String decrypt(String encryptedMessage) {
        String decryptedMessage;
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, KEY);
            byte[] decodedBytes = Base64.getDecoder().decode(encryptedMessage);
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);
            decryptedMessage = new String(decryptedBytes);
        } catch (Exception e) {
            log.error("Error in decrypt: " + e);
            throw new RuntimeException("Error in decrypt!!!" + e);
        }
        return decryptedMessage;
    }
}