package dima.evseenko.droid;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class EncryptorUtil {
    public static byte[] encryptMessage(byte[] message, SecretKey secretKey) {
        return messageEncryption(message, secretKey, Cipher.ENCRYPT_MODE);
    }

    public static byte[] decryptMessage(byte[] message, SecretKey secretKey) {
        return messageEncryption(message, secretKey, Cipher.DECRYPT_MODE);
    }

    private static byte[] messageEncryption(byte[] message, SecretKey secretKey, int opmode) {
        MessageEncryptor encryptor = (msg, encryptionKey) -> {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(opmode, encryptionKey);
            return cipher.doFinal(msg);
        };

        try {
            return encryptor.encrypt(message, secretKey);
        } catch (Exception e) {
            return null;
        }
    }
}
