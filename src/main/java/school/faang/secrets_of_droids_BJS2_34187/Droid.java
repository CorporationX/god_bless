package school.faang.secrets_of_droids_BJS2_34187;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Droid {
    private String name;

    public String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptedMessage = (cryptMessage, cryptKey) -> {
            StringBuilder resultMessage = new StringBuilder();
            for (char character : cryptMessage.toCharArray()) {
                if (Character.isLetter(character)) {
                    char letterCase = Character.isLowerCase(character) ? 'a' : 'A';
                    resultMessage.append((char) ((character - letterCase + cryptKey) % 26 + letterCase));
                } else {
                    resultMessage.append(character);
                }
            }
            System.out.println(name + " sent encrypted message: " + resultMessage);
            return resultMessage.toString();
        };
        return encryptedMessage.encrypt(message, key);
    }

    public String decryptMessage(String message, int key) {
        DroidMessageEncryptor decryptedMessage = (cryptMessage, cryptKey) -> {
            StringBuilder resultMessage = new StringBuilder();

            for (char character : cryptMessage.toCharArray()) {
                if (Character.isLetter(character)) {
                    char letterCase = Character.isLowerCase(character) ? 'a' : 'A';
                    resultMessage.append((char) ((character - letterCase - cryptKey + 26) % 26 + letterCase));
                } else {
                    resultMessage.append(character);
                }
            }
            return resultMessage.toString();
        };
        return decryptedMessage.encrypt(message, key);
    }

    public void sendMessage(Droid recipient, String message, int key) {
        receiveMessage(recipient, encryptMessage(message, key), key);
    }

    public void receiveMessage(Droid recipient, String message, int key) {
        System.out.println(recipient.getName() + " got decrypted message: " + decryptMessage(message, key));
    }
}