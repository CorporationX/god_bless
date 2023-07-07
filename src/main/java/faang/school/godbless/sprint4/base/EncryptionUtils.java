package faang.school.godbless.sprint4.base;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class EncryptionUtils {
    private final String KEY = "1234567890123456"; // 16-character key

    public String encrypt(String message) throws Exception {
        Cipher cipher = getCipher(Cipher.ENCRYPT_MODE);
        byte[] encrypted = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public String decrypt(String message) throws Exception {
        Cipher cipher = getCipher(Cipher.DECRYPT_MODE);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(message));
        return new String(decrypted, StandardCharsets.UTF_8);
    }

    private Cipher getCipher(int mode) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(KEY.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(mode, secretKeySpec);
        return cipher;
    }
}
