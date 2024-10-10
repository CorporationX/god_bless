package school.faang.secrets_of_droids_BJS2_34187;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Droid {
    private static final int ALPHABET_LENGTH = 26;
    private static final char UPPERCASE_CHAR = 'A';
    private static final char LOWERCASE_CHAR = 'a';

    private String name;

    public String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptedMessage = (cryptMessage, cryptKey) -> {
            StringBuilder resultMessage = new StringBuilder();
            for (char character : cryptMessage.toCharArray()) {
                if (Character.isLetter(character)) {
                    char letterCase = Character.isLowerCase(character) ? LOWERCASE_CHAR : UPPERCASE_CHAR;
                    resultMessage.append((char) ((character - letterCase + cryptKey) % ALPHABET_LENGTH + letterCase));
                } else {
                    resultMessage.append(character);
                }
            }
            return resultMessage.toString();
        };
        return encryptedMessage.encrypt(message, key);
    }

    public String decryptMessage(String encryptedMessage, int key) {
        return encryptMessage(encryptedMessage, ALPHABET_LENGTH - (key % ALPHABET_LENGTH));
    }

    public void sendMessage(Droid recipient, String message, int key) {
        System.out.println(name + " sent encrypted message: " + encryptMessage(message, key));
        receiveMessage(recipient, encryptMessage(message, key), key);
    }

    public void receiveMessage(Droid recipient, String message, int key) {
        System.out.println(recipient.getName() + " got decrypted message: " + decryptMessage(message, key));
    }
}