package droids;

import lombok.AllArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
public class Droid {
    private static final int ALPHABET_LENGTH = 26;
    private final String name;

    private String processMessage(String message, int key) {
        StringBuilder result = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) ((c - base + key + ALPHABET_LENGTH) % ALPHABET_LENGTH + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public String encryptMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (msg, key) -> processMessage(msg, key);
        return encryptor.encrypt(message, encryptionKey);
    }

    public String decryptMessage(String message, int decryptionKey) {
        DroidMessageEncryptor decryptor = (msg, key) -> processMessage(msg, -key);
        return decryptor.encrypt(message, decryptionKey);
    }

    public void sendMessage(Droid droid, String message, int key) {
        Objects.requireNonNull(droid, "Droid cannot be null");
        Objects.requireNonNull(message, "Message cannot be null");

        String encryptedMessage = encryptMessage(message, key);
        System.out.printf("%s отправил зашифрованное сообщение: %s%n", name, encryptedMessage);
        droid.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String encryptedMessage, int key) {
        Objects.requireNonNull(encryptedMessage, "Encrypted message cannot be null");

        String decryptedMessage = decryptMessage(encryptedMessage, key);
        System.out.printf("%s получил расшифрованное сообщение: %s%n", name, decryptedMessage);
    }
}
