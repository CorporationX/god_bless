package BJS2_57511;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Droid {
    private final String name;

    private String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, k) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    encryptedMessage.append((char) ((c - base + k) % 26 + base));
                } else {
                    encryptedMessage.append(c);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.encrypt(message, key);
    }

    private String decryptMessage(String message, int key) {
        DroidMessageEncryptor decryptor = (msg, k) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    decryptedMessage.append((char) ((c - base - k + 26) % 26 + base));
                } else {
                    decryptedMessage.append(c);
                }
            }
            return decryptedMessage.toString();
        };
        return decryptor.encrypt(message, key);
    }

    public void sendMessage(Droid recipient, String message, int key) {
        String encryptedMessage = encryptMessage(message, key);
        recipient.receiveMessage(encryptedMessage, key);
    }

    private void receiveMessage(String message, int key) {
        String decryptedMessage = decryptMessage(message, key);
        log.info(decryptedMessage);
    }
}
