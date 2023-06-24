package faang.school.godbless.droidSecrets;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Droid {
    public String sendEncryptedMessage(String message, Integer key) {
        checkArgs(message, key);
        DroidMessageEncryptor encryptor = (m, k) -> {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < m.length(); i++) {
                int ch = m.charAt(i) + k;
                if (ch > 126) ch = 32;
                result.append((char) ch);
            }
            return result.toString();
        };

        return encryptor.crypt(message, key);
    }

    public String receiveEncryptedMessage(String encryptedMessage, Integer key) {
        checkArgs(encryptedMessage, key);
        DroidMessageEncryptor decoder = (m, k) -> {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < m.length(); i++) {
                int ch = m.charAt(i) - k;
                if (ch < 32) ch = 126;
                result.append((char) ch);
            }
            return result.toString();
        };

        return decoder.crypt(encryptedMessage, key);
    }

    private static void checkArgs(String message, Integer key) {
        if (message.isEmpty() || key < 1) {
            throw new IllegalArgumentException("Incorrect data was transmitted");
        }
    }
}
