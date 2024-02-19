package faang.school.godbless.droidSecrets;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Droid {
    public String sendEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (source, target) -> {
            char[] chars = message.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                chars[i] = (char) (chars[i] + encryptionKey);
            }
            return new String(chars);
        };

        return encryptor.encrypt(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (source, target) -> {
            char[] chars = message.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                chars[i] = (char) (chars[i] - encryptionKey);
            }
            return new String(chars);
        };

        return encryptor.encrypt(message, encryptionKey);
    }
}
