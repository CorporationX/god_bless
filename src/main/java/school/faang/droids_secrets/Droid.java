package school.faang.droids_secrets;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Droid {
    private String name;

    public Droid(String name) {
        this.name = name;
    }

    public void sendMessage(Droid droidReceiver, String message, int encryptionKey) {
        log.debug("Message sent with a text: {} and encryptionKey: {}", message, encryptionKey);
        String encryptedMessage = this.encryptMessage(message, encryptionKey);
        log.debug("Message encrypted to {}", encryptedMessage);
        droidReceiver.receiveMessage(encryptedMessage, encryptionKey);
    }

    public void receiveMessage(String encryptedMessage, int encryptionKey) {
        String decryptedMessage = this.decryptMessage(encryptedMessage, encryptionKey);
        System.out.printf("Decrypted message received: %s%n", decryptedMessage);
    }

    private String encryptMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (msg, key) -> {
            StringBuilder encryptedMessage = new StringBuilder();

            for (Character letter : msg.toCharArray()) {
                char encryptedChar = letter;
                if (Character.isLetter(letter) && Character.isUpperCase(letter)) {
                    encryptedChar = (char) (((letter - 'A') + key) % 26 + 'A');
                } else if (Character.isLetter(letter) && Character.isLowerCase(letter)) {
                    encryptedChar = (char) (((letter - 'a') + key) % 26 + 'a');
                }
                encryptedMessage.append(encryptedChar);
            }
            return encryptedMessage.toString();
        };
        return encryptor.encryptMessage(message, encryptionKey);
    }

    private String decryptMessage(String encryptedMessage, int encryptionKey) {
        DroidMessageEncryptor decryptor = (msg, key) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (Character letter : msg.toCharArray()) {
                char encryptedChar = letter;
                if (Character.isLetter(letter) && Character.isUpperCase(letter)) {
                    encryptedChar = (char) (((encryptedChar - 'A') - key + 26) % 26 + 'A');
                } else if (Character.isLetter(letter) && Character.isLowerCase(letter)) {
                    encryptedChar = (char) (((encryptedChar - 'a') - key + 26) % 26 + 'a');
                }
                decryptedMessage.append(encryptedChar);
            }
            return decryptedMessage.toString();
        };
        return decryptor.encryptMessage(encryptedMessage, encryptionKey);
    }
}
