package bjs2_70412;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Droid {
    private String name;

    @FunctionalInterface
    public interface DroidMessageEncryptor {
        String encrypt(String message, int key);
    }

    public String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, k) -> {
            StringBuilder result = new StringBuilder();
            for (char character : msg.toCharArray()) {
                if (Character.isLetter(character)) {
                    char characterCase = Character.isLowerCase(character) ? 'a' : 'A';
                    char encryptedCharacter = (char) ((character - characterCase + k) % 26 + characterCase);
                    result.append(encryptedCharacter);
                } else {
                    result.append(character);
                }
            }
            return result.toString();
        };
        return encryptor.encrypt(message, key);
    }

    public String decryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, k) -> {
            StringBuilder result = new StringBuilder();
            for (char character : msg.toCharArray()) {
                if (Character.isLetter(character)) {
                    char characterCase = Character.isLowerCase(character) ? 'a' : 'A';
                    char encryptedCharacter = (char) ((character - characterCase - k + 26) % 26 + characterCase);
                    result.append(encryptedCharacter);
                } else {
                    result.append(character);
                }
            }
            return result.toString();
        };
        return encryptor.encrypt(message, key);
    }

    public void sendMessage(Droid droid, String message, int key) {
        String encryptedMessage = encryptMessage(message, key);
        System.out.println("Encrypted message: " + encryptedMessage);
        droid.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String message, int key) {
        String decryptedMessage = decryptMessage(message, key);
        System.out.println("Decrypted message: " + decryptedMessage);
    }
}
