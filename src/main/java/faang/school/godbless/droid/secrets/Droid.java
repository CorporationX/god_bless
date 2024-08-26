package faang.school.godbless.droid.secrets;

import lombok.Setter;

import java.util.Arrays;

@Setter
public class Droid {

    public String sendEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor droidMessageEncryptor = (msg, key) -> {
            char[] charArray = msg.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            for (char c : charArray) {
                stringBuilder.append((char) (c + key));
            }
            return stringBuilder.toString();
        };

        return droidMessageEncryptor.encrypt(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String encryptedMessage, int encryptionKey) {
        DroidMessageEncryptor droidMessageEncryptor = (msg, key) -> {
            char[] charArray = msg.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            for (char c : charArray) {
                stringBuilder.append((char) (c - key));
            }
            return stringBuilder.toString();
        };

        return droidMessageEncryptor.encrypt(encryptedMessage, encryptionKey);
    }
}
