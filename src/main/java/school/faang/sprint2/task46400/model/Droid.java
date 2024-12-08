package school.faang.sprint2.task46400.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Droid {
    private final String name;

    public String encryptMessage(String originalMessage, int encryptionKey) {
        DroidMessageEncryptor encryptor = (message, key) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char ch : message.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    encryptedMessage.append((char) ((ch - base + key) % 26 + base));
                } else {
                    encryptedMessage.append(ch);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.encryptDecrypt(originalMessage, encryptionKey);
    }

    public String decryptMessage(String encriptedMessage, int decryptionKey) {
        DroidMessageEncryptor decryptor = (message, key) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char ch : message.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    decryptedMessage.append((char) ((ch - base - key) % 26 + base));
                } else {
                    decryptedMessage.append(ch);
                }
            }
            return decryptedMessage.toString();
        };
        return decryptor.encryptDecrypt(encriptedMessage, decryptionKey);
    }

    public void sendMessage(Droid droid, String message, int key) {
        String encryptedMessage = this.encryptMessage(message, key);
        System.out.println("Droid " + this.name
                + " send encrypted message to droid " + droid.getName()
                + ": " + encryptedMessage);
        droid.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String message, int key) {
        String decryptedMessage = this.decryptMessage(message, key);
        System.out.println("Droid " + this.name + " recieve message and decrypt it: " + decryptedMessage);
    }
}
