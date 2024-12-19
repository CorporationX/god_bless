package school.faang.bjs246358;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Droid {
    private final String droidName;

    public Droid(String name) {
        if (name == null || name.trim().isEmpty()) {
            log.error("Message cannot be null");
            throw new IllegalArgumentException("Message must not be null");
        }
        this.droidName = name;
    }

    public String encryptMessage(String message, int key) {
        if (message == null || message.trim().isEmpty() || key == 0) {
            log.error("Message in 'encryptMessage' method cannot be null or empty, and key must not be zero");
            throw new IllegalArgumentException("Message must not be null or empty, and key must not be zero");
        }
        String encryptedMessage = getString(message, key);
        log.info("Message encrypted successfully");
        return encryptedMessage;
    }

    private static String getString(String message, int key) {
        DroidMessageEncryptor encryptor = ((msg, k) -> {
            StringBuilder encrypted = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    encrypted.append((char) ((c - base + k) % 26 + base));
                } else {
                    encrypted.append(c);
                }
            }
            return encrypted.toString();
        });
        return encryptor.encryptOrDecrypt(message, key);
    }

    public String decryptMessage(String message, int key) {
        if (message == null || message.trim().isEmpty() || key == 0) {
            log.error("Message in 'decryptMessage' method cannot be null or empty, and key must not be zero");
            throw new IllegalArgumentException("Message must not be null or empty, and key must not be zero");
        }
        return encryptMessage(message, 26 - key);
    }

    public void sendMessage(String message, int key, Droid recipientName) {
        if (message == null || message.trim().isEmpty() || key == 0 || recipientName == null) {
            log.error("Message, key, and recipientName in 'sendMessage' method cannot be null or empty, "
                    + "and key must not be zero");
            throw new IllegalArgumentException("Message, key, and recipientName must not be null or empty, "
                    + "and key must not be zero");
        }
        String encryptedMessage = encryptMessage(message, key);
        System.out.println(this.droidName + " sent an encrypted message: " + encryptedMessage);
        recipientName.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String encryptedMessage, int key) {
        if (encryptedMessage == null || encryptedMessage.trim().isEmpty() || key == 0) {
            log.error("Encrypted message in 'receiveMessage' method cannot be null or empty,"
                    + " and key must not be zero");
            throw new IllegalArgumentException("Encrypted message must not be null or empty, and key must not be zero");
        }
        String decryptedMessage = decryptMessage(encryptedMessage, key);
        System.out.println(this.droidName + " received a decrypted message: " + decryptedMessage);
    }
}