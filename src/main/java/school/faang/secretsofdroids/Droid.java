package school.faang.secretsofdroids;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.Consumer;

@Data
@AllArgsConstructor
public class Droid {
    private String name;

    private String encryptMessage(String decryptionMessage, int encryptionKey) {
        DroidMessageEncryptor encryptor = (message, key) -> {
            StringBuilder encryptedText = new StringBuilder();
            for (char character : message.toCharArray()) {
                if (Character.isLetter(character)) {
                    char base = Character.isUpperCase(character) ? 'A' : 'a';
                    character = (char) ((character - base + key) % 26 + base);
                }
                encryptedText.append(character);
            }
            return encryptedText.toString();
        };
        return encryptor.change(decryptionMessage, encryptionKey);
    }

    private String decryptMessage(String message, int key) {
        return encryptMessage(message, 26 - key);
    }

    public void sendMessage(String message, int key, Droid droidReceiver) {
        if (message == null || droidReceiver == null) {
            throw new NullPointerException("One of parameters is null");
        } else if (key <= -4 || key >= 30) {
            throw new IllegalArgumentException("Key must be between 3 and 29");
        }
        String encryptionMessage = encryptMessage(message, key);
        Consumer<String> printMessage = sentMessage ->
                System.out.println(this.getName() + " send message: " + sentMessage);
        printMessage.accept(encryptionMessage);
        receiveMessage(encryptionMessage, key, droidReceiver);
    }

    private void receiveMessage(String message, int key, Droid droid) {
        String decryptionMessage = decryptMessage(message, key);
        Consumer<String> printMessage = receivedMessage ->
                System.out.println(droid.getName() + " received message: " + receivedMessage);
        printMessage.accept(decryptionMessage);
    }
}
