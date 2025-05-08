package bjs2_70412;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Droid {
    private String name;
    private static final DroidMessageEncryptor ENCRYPTOR = (message, key) -> {
        StringBuilder result = new StringBuilder();
        for (char character : message.toCharArray()) {
            if (Character.isLetter(character)) {
                char characterCase = Character.isLowerCase(character) ? 'a' : 'A';
                char encryptedCharacter = (char) ((character - characterCase + key + 26) % 26 + characterCase);
                result.append(encryptedCharacter);
            } else {
                result.append(character);
            }
        }
        return result.toString();} ;

    @FunctionalInterface
    public interface DroidMessageEncryptor {
        String encrypt(String message, int key);
    }

    public void sendMessage(Droid droid, String message, int key) {
        String encryptedMessage = ENCRYPTOR.encrypt(message, key);
        System.out.println("Encrypted message: " + encryptedMessage);
        droid.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String message, int key) {
        String decryptedMessage = ENCRYPTOR.encrypt(message, -key);
        System.out.println("Decrypted message: " + decryptedMessage);
    }
}
