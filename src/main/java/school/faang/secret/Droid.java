package school.faang.secret;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Droid {
    private String name;

    private final int NUMBER_OF_ENGLISH_LETTERS = 26;

    public String encryptMessage(String message, Integer key) {
        return processMessage(message, key);
    }

    public String decryptMessage(String message, Integer key) {
        return processMessage(message, -key);
    }

    private String processMessage(String message, Integer key) {
        DroidMessageEncryptor encryptor = (msg, encryptionKey) -> {
            StringBuilder result = new StringBuilder();
            for (Character c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    result.append((char) ((c - base + encryptionKey + NUMBER_OF_ENGLISH_LETTERS) % NUMBER_OF_ENGLISH_LETTERS + base));
                } else {
                    result.append(c);
                }
            }
            return result.toString();
        };
        return encryptor.encrypt(message, key);
    }

    public String sendMessage(String message, int key) {
        return encryptMessage(message, key);
    }

    public String receiveMessage(String encryptedMessage, int key) {
        return decryptMessage(encryptedMessage, key);
    }
}
