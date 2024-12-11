package school.faang.sprint2.task46300.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Droid {
    private static final int ALPHABET_SIZE = 26;

    private final String name;

    private String encryptMessage(String originalMessage, int encryptionKey) {
        DroidMessageEncryptor encryptor = (message, key) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char ch : message.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    encryptedMessage.append((char) ((ch - base + key) % ALPHABET_SIZE + base));
                } else {
                    encryptedMessage.append(ch);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.encrypt(originalMessage, encryptionKey);
    }

    public void sendMessage(Droid droid, String message, int key) {
        String encryptedMessage = this.encryptMessage(message, key);
        System.out.println("Droid " + this.name
                + " send encrypted message to droid " + droid.getName()
                + ": " + encryptedMessage);
        droid.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String message, int key) {
        String decryptedMessage = this.encryptMessage(message, ALPHABET_SIZE - key);
        System.out.println("Droid " + this.name + " got a message and decrypt it: " + decryptedMessage);
    }
}
