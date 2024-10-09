package school.faang.droidsecrets;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Droid {
    private String name;

    public void sendMessage(Droid droid, String message, int key) {
        String encryptedMessage = encryptMessage(message, key, this::encrypt);
        System.out.println("\nDroid " + this.name + " has sent the encrypted message: " + encryptedMessage);
        receiveMessage(droid, encryptedMessage, key);
    }

    public void receiveMessage(Droid droid, String message, int key) {
        String decryptedMessage = decryptMessage(message, key, this::decrypt);
        System.out.println("Droid " + droid.name + " has received and decrypted the message: " + decryptedMessage);
    }

    private String encryptMessage(String message, int key, DroidMessageEncryptor encryptor) {
        return encryptor.process(message, key);
    }

    private String decryptMessage(String message, int key, DroidMessageEncryptor decryptor) {
        return decryptor.process(message, key);
    }

    private String encrypt(String message, int key) {
        StringBuilder result = new StringBuilder();
        for (char character : message.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                result.append((char) ((character - base + key) % 26 + base));
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    private String decrypt(String message, int key) {
        return encrypt(message, -key + 26);
    }
}
