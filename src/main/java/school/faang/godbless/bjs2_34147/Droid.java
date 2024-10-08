package school.faang.godbless.bjs2_34147;

import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.stream.IntStream;

@AllArgsConstructor
public class Droid {
    private static final DroidMessageEncryptor ENCRYPTOR = (text, key) -> {
        char[] symbols = text.toCharArray().clone();
        IntStream.range(0, symbols.length).forEach(i -> symbols[i] += (char) key);
        return new String(symbols);
    };
    private static final DroidMessageEncryptor DECRYPTOR = (text, key) -> {
        char[] symbols = text.toCharArray().clone();
        IntStream.range(0, symbols.length).forEach(i -> symbols[i] -= (char) key);
        return new String(symbols);
    };

    private String name;

    public void sendMessage(String message, int key, Droid recipient) {
        validateMessage(message);
        validateKey(key);
        validateRecipient(recipient);

        String encryptedMessage = encryptMessage(message, key);
        recipient.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String message, int key) {
        validateMessage(message);
        validateKey(key);

        String decryptedMessage = decryptMessage(message, key);
        System.out.println("Droid " + name + " received message: " + decryptedMessage);
    }

    private String encryptMessage(String message, int key) {
        return ENCRYPTOR.processMessage(message, key);
    }

    private String decryptMessage(String message, int key) {
        return DECRYPTOR.processMessage(message, key);
    }

    private void validateMessage(String message) {
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("null or empty message");
        }
    }

    private void validateKey(int key) {
        if (key <= 0 || key > 10) {
            throw new IllegalArgumentException("key must be in range (0; 10]");
        }
    }

    private void validateRecipient(Droid recipient) {
        if (recipient == null) {
            throw new IllegalArgumentException("recipient must not be null");
        }
    }
}
