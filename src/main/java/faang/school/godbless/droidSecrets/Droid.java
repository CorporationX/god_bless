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
                result.append((char) (m.charAt(i) + k));
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
                result.append((char) (m.charAt(i) - k));
            }
            return result.toString();
        };

        return decoder.crypt(encryptedMessage, key);
    }

    private static void checkArgs(String message, Integer key) {
        if (message.isEmpty() || key < 1) {
            throw new IllegalArgumentException("Переданы неверные данные");
        }
    }
}
