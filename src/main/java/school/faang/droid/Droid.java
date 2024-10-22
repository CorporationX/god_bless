package school.faang.droid;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Droid {
    String name;

    public String encryptMessage(String message, Integer key) {
        DroidMessageEncryptor encryptor = (msg, k) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char c : message.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';

                    char shifted = (char) ((c - base + k) % 26 + base);

                    encryptedMessage.append(shifted);
                } else {
                    encryptedMessage.append(c);
                }

            }
            return encryptedMessage.toString();
        };
        return encryptor.encrypt(message, key);
    }

    public String decryptMessage(String message, Integer key) {
        DroidMessageEncryptor decryptor = (msg, k) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char c : message.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    char shifted = (char) ((c - base - k + 26) % 26 + base);
                    decryptedMessage.append(shifted);
                } else {
                    decryptedMessage.append(c);
                }
            }
            return decryptedMessage.toString();
        };
        return decryptor.encrypt(message, key);
    }

    public void sendMessage(String message, Integer key, Droid droid) {
        String encryptMessage = encryptMessage(message, key);
        droid.receiveMessage(encryptMessage, key);
    }

    public void receiveMessage(String encryptMessage, Integer key) {
        String decryptMessage = decryptMessage(encryptMessage, key);
        System.out.println(decryptMessage);
    }
}
