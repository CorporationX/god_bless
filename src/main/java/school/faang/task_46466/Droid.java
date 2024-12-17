package school.faang.task_46466;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Droid {
    private static final int LETTERS_NUMBER = 26;
    private String name;

    public Droid(String name) {
        this.name = name;
    }

    private String encryptMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (msg, k) -> {
            StringBuilder result = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    result.append((char) ((c - base + k) % LETTERS_NUMBER + base));
                } else {
                    result.append(c);
                }
            }
            return result.toString();
        };
        return encryptor.process(message, encryptionKey);
    }

    private String decryptMessage(String encryptedMessage, int encryptionKey) {
        DroidMessageEncryptor decryptor = (msg, k) -> {
            StringBuilder result = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    result.append((char) ((c - base - k + LETTERS_NUMBER) % LETTERS_NUMBER + base));
                } else {
                    result.append(c);
                }
            }
            return result.toString();
        };
        return decryptor.process(encryptedMessage, encryptionKey);
    }

    public void sendMessage(Droid receiver, String message, int encryptionKey) {
        log.info("{} set message: {}", this.name, message);
        String encryptedMessage = encryptMessage(message, encryptionKey);
        log.info("Encrypted message: {}", encryptedMessage);
        receiver.receiveMessage(encryptedMessage, encryptionKey);
    }

    public void receiveMessage(String encryptedMessage, int encryptedKey) {
        log.info("{} received message: ", this.name);
        String decryptedMessage = decryptMessage(encryptedMessage, encryptedKey);
        log.info("Deciphered message: {}", decryptedMessage);
    }
}
