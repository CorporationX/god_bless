package faang.school.godbless.BJS2_2986;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Droid {
    public String sendEncryptedMessage(String message, Integer encryptionKey) {
        DroidMessageEncryptor encryptor = (message1, encryptionKey1) -> {
            var sb = new StringBuilder();
            for (var chr : message1.chars().toArray()) {
                sb.append((char) (chr + encryptionKey1));
            }
            return sb.toString();
        };
        return encryptor.encrypt(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String message, Integer encryptionKey) {
        DroidMessageEncryptor encryptor = (message1, encryptionKey1) -> {
            var sb = new StringBuilder();
            for (var chr : message1.chars().toArray()) {
                sb.append((char) (chr - encryptionKey1));
            }
            return sb.toString();
        };
        return encryptor.encrypt(message, encryptionKey);
    }

}
