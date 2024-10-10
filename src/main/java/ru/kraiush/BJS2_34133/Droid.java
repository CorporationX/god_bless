package ru.kraiush.BJS2_34133;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Droid {
    private String name;

    public String encryptMessage(String messageForEncryption, int encryptionKey) {
        DroidMessageEncryptor encryptor = (message, key) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (Character character : message.toCharArray()) {
                if (Character.isLetter(character)) {
                    char letter = Character.isLowerCase(character) ? 'a' : 'A';
                    encryptedMessage.append((char) ((character - letter + key) % 26 + letter));
                } else {
                    encryptedMessage.append(character);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.encrypt(messageForEncryption, encryptionKey);
    }

    public String decryptMessage(String messageForDecryption, int encryptionKey) {
        DroidMessageEncryptor decrypt = (message, key) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (Character character : message.toCharArray()) {
                if (Character.isLetter(character)) {
                    char letter = Character.isLowerCase(character) ? 'a' : 'A';
                    decryptedMessage.append((char) ((character - letter - key + 26) % 26 + letter));
                } else {
                    decryptedMessage.append(character);
                }
            }
            return decryptedMessage.toString();
        };
        return decrypt.encrypt(messageForDecryption, encryptionKey);
    }

    public void sendMessage(String message, int encryptionKey, Droid droid) {
        String encryptedMessage = encryptMessage(message, encryptionKey);
        System.out.println(this.getName() + " sent the encrypted message: " + encryptedMessage);
        receiveMessage(encryptedMessage, encryptionKey, droid);
    }

    private void receiveMessage(String encryptedMessage, int encryptionKey, Droid droid) {
        String decryptedMessage = decryptMessage(encryptedMessage, encryptionKey);
        System.out.println(droid.getName() + " received the decrypted message: " + decryptedMessage);
    }
}
