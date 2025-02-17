package school.faang.bjs2_57596;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class Droid {
    private static final int ALPHABET_SIZE = 26;
    private final String name;

    public Droid(String name) {
        validateName(name);
        this.name = name;
    }

    private String encryptMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (msg, key) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char ch : message.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isUpperCase(ch) ? 'A' : 'a';
                    int shift = (ch - base + key) % ALPHABET_SIZE;
                    encryptedMessage.append((char) (shift + base));
                } else {
                    encryptedMessage.append(ch);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.encrypt(message, encryptionKey);
    }

    private String decryptMessage(String message, int encryptionKey) {
        DroidMessageEncryptor decoder = (msg, key) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char ch : message.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isUpperCase(ch) ? 'A' : 'a';
                    int shift = ((ch - base - key) % ALPHABET_SIZE + ALPHABET_SIZE) % ALPHABET_SIZE;
                    decryptedMessage.append((char) (shift + base));
                } else {
                    decryptedMessage.append(ch);
                }
            }
            return decryptedMessage.toString();
        };
        return decoder.encrypt(message, encryptionKey);
    }

    public void sendMessage(String message, int encryptionKey, Droid droid) {
        validateMessage(message);
        validateEncryptionKey(encryptionKey);
        String encryptedMessage = encryptMessage(message, encryptionKey);
        droid.receiveMessage(encryptedMessage, encryptionKey);
        log.info("Droid {} sent encrypted message: {}.", droid.getName(), encryptedMessage);
    }

    private void receiveMessage(String message, int encryptionKey) {
        String decryptedMessage = decryptMessage(message, encryptionKey);
        log.info("Droid {} got decrypted message: {}.", this.getName(), decryptedMessage);
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The name can't be null or blank. Provided value: " + name);
        }
    }

    private void validateMessage(String message) {
        if (message == null) {
            throw new IllegalArgumentException("The message can't be null.");
        }
    }

    private void validateEncryptionKey(int encryptionKey) {
        if (encryptionKey < 0) {
            throw new IllegalArgumentException("The encryptionKey can't be less than 0.");
        }
    }
}