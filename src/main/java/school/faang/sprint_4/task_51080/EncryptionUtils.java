package school.faang.sprint_4.task_51080;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.*;
import java.util.Base64;

@Slf4j
@RequiredArgsConstructor
public class EncryptionUtils {
    private static final SecretKey KEY;

    static {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            KEY = keyGenerator.generateKey();
        } catch (Exception e) {
            throw new RuntimeException("Ошибка генерации ключа AES", e);
        }
    }

    public static String encrypt(String message) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, KEY);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedMessage) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, KEY);
        byte[] decodeBytes = Base64.getDecoder().decode(encryptedMessage);
        byte[] decryptedBytes = cipher.doFinal(decodeBytes);
        return new String(decryptedBytes);
    }
}
