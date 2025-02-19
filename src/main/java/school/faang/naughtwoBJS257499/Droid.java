package school.faang.naughtwoBJS257499;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Droid {
    private final String name;

    public Droid(String name) {
        checkName(name);
        this.name = name;
    }

    public void sendMessage(String message, int key, Droid recipient) {
        checkMessage(message);
        checkKey(key);
        String droidSendMessage = encryptMessage(message, key);
        System.out.printf("%s sent an encrypted message: %s%n", this.getName(), droidSendMessage);
        receiveMessage(droidSendMessage, key, recipient);
    }

    private void receiveMessage(String message, int key, Droid recipient) {
        String droidReceiveMessage = decryptMessage(message, key);
        System.out.printf("%s received an encrypted message: %s%n", recipient.getName(), droidReceiveMessage);
    }

    private String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (droidMessage, droidKey) -> {
            StringBuilder processedMessage = new StringBuilder();
            for (char symbol : droidMessage.toCharArray()) {
                if (Character.isLetter(symbol)) {
                    char base = Character.isLowerCase(symbol) ? 'a' : 'A';
                    processedMessage.append((char) ((symbol - base + droidKey) % 26 + base));
                } else {
                    processedMessage.append(symbol);
                }
            }
            return processedMessage.toString();
        };
        return encryptor.encrypt(message, key);
    }

    private String decryptMessage(String message, int key) {
        DroidMessageEncryptor decryptor = (droidMessage, droidKey) -> {
            StringBuilder processedMessage = new StringBuilder();
            for (char symbol : droidMessage.toCharArray()) {
                if (Character.isLetter(symbol)) {
                    char base = Character.isLowerCase(symbol) ? 'a' : 'A';
                    processedMessage.append((char) ((symbol - base - droidKey + 26) % 26 + base));
                } else {
                    processedMessage.append(symbol);
                }
            }
            return processedMessage.toString();
        };
        return decryptor.encrypt(message, key);
    }

    private void checkName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be 'null' or empty.");
        }
    }

    private void checkMessage(String message) {
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Message cannot be 'null' or empty.");
        }
    }

    private void checkKey(int key) {
        if (key <= 0) {
            throw new IllegalArgumentException("Key must be greater than zero.");
        }
    }
}
