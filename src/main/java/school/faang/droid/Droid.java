package school.faang.droid;

import lombok.Data;

/**
 * @author Danil Pudovkin
 * @since 11.06.2025
 */
@Data
public class Droid {

    private final String name;

    private final DroidMessageEncryptor caesarEncryptor = (message, shift) -> {
        var result = new StringBuilder();
        for (char character : message.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                int offset = (character - base + shift) % 26;
                result.append((char) (base + offset));
            } else {
                result.append(character);
            }
        }
        return result.toString();
    };

    private final DroidMessageEncryptor caesarDecryptor = (message, shift)
            -> caesarEncryptor.handle(message, 26 - (shift % 26));

    public void sendMessage(Droid droid, String message, int encryptionKey) {
        var encryptedMessage = encryptMessage(message, encryptionKey);
        System.out.printf("%s отправил зашифрованное сообщение: %s%n", name, encryptedMessage);
        droid.receiveMessage(encryptedMessage, encryptionKey);
    }

    private void receiveMessage(String message, int encryptionKey) {
        var decryptedMessage = decryptMessage(message, encryptionKey);
        System.out.printf("%s получил расшифрованное сообщение: %s%n", name, decryptedMessage);
    }

    private String encryptMessage(String message, int encryptionKey) {
        return caesarEncryptor.handle(message, encryptionKey);
    }

    private String decryptMessage(String message, int encryptionKey) {
        return caesarDecryptor.handle(message, encryptionKey);
    }
}
