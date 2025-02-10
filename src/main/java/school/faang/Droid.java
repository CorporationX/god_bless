package school.faang;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Droid {
    Logger logger = LoggerFactory.getLogger(Droid.class);
    @Getter
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
                    int shift = (ch - base + key) % 26;
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
                    int shift = ((ch - base - key) % 26 + 26) % 26;
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
        droid.receiveMessage(encryptedMessage, encryptionKey, droid);
        logger.info("Droid {} sent encrypted message: {}.", droid.getName(), encryptedMessage);
    }

    private void receiveMessage(String message, int encryptionKey, Droid droid) {
        String decryptedMessage = decryptMessage(message, encryptionKey);
        logger.info("Droid {} got encrypted message: {}.", droid.getName(), decryptedMessage);
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The message can't be null or empty. Provided value: " + name);
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
