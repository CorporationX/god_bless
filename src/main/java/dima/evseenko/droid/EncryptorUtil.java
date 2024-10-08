package dima.evseenko.droid;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class EncryptorUtil {
    public static byte[] encryptMessage(byte[] message, SecretKey secretKey) {
        MessageEncryptor encryptor = (msg, encryptionKey) -> {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, encryptionKey);
            return cipher.doFinal(msg);
        };

        try {
            return encryptor.encrypt(message, secretKey);
        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] decryptMessage(byte[] message, SecretKey secretKey) {
        MessageEncryptor decryptor = (msg, encryptionKey) -> {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, encryptionKey);
            return cipher.doFinal(msg);
        };

        try {
            return decryptor.encrypt(message, secretKey);
        } catch (Exception e) {
            return null;
        }
    }
}
