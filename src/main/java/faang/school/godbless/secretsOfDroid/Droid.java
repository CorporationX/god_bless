package faang.school.godbless.secretsOfDroid;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Droid {
    private String name;

    public String sendEncryptedMessage(String originMsg, int encryptionKey) {
        DroidMessageEncryptor encryptor = (message, key) -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < message.length(); i++){
                stringBuilder.append((char)(message.charAt(i) + key));
            }
            return stringBuilder.toString();
        };
        return encryptor.encrypt(originMsg, encryptionKey);
    }

    public String receiveEncryptedMessage(String encryptedMsg, int encryptionKey) {
        DroidMessageEncryptor encryptor = (message, key) -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < message.length(); i++){
                stringBuilder.append((char)(message.charAt(i) - key));
            }
            return stringBuilder.toString();
        };
        return encryptor.encrypt(encryptedMsg, encryptionKey);
    }
}
