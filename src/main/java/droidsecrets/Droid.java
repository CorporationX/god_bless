package droidsecrets;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Droid {
    private static final DroidMessageEncryptor ENCRYPTOR = (originalMessage, key) -> {
        StringBuilder result = new StringBuilder();
        for (char character : originalMessage.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                char shifted = (char) ((character - base + key) % 26 + base);
                result.append(shifted);
            } else {
                result.append(character);
            }
        }
        return result.toString();
    };
    private static final DroidMessageEncryptor DECRYPTOR = (originalMessage, key) -> {
        StringBuilder result = new StringBuilder();
        for (char character : originalMessage.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                char shifted = (char) ((character - base - key + 26) % 26 + base);
                result.append(shifted);
            } else {
                result.append(character);
            }
        }
        return result.toString();
    };

    private String name;

    public String encryptMessage(String message, int encryptKey) {
        return ENCRYPTOR.apply(message, encryptKey);
    }

    public String decryptMessage(String message, int encryptKey) {
        return DECRYPTOR.apply(message, encryptKey);
    }

    public void sendMessage(String message, int encryptKey, Droid droid) {
        String encryptedMessage = encryptMessage(message, encryptKey);
        System.out.println(this.name + " отправил зашифрованное сообщение: " + encryptedMessage);
        droid.receiveMessage(encryptedMessage, encryptKey);
    }

    public void receiveMessage(String message, int encryptKey) {
        System.out.println(this.name + " получил расшифрованное сообщение: " + decryptMessage(message, encryptKey));
    }
}
