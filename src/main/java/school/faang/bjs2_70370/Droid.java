package school.faang.bjs2_70370;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Droid {
    private String name;

    public String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, encryptorKey) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (Character character : message.toCharArray()) {
                if (Character.isLetter(character)) {
                    char baseChar = Character.isLowerCase(character) ? 'a' : 'A';
                    encryptedMessage.append((char) ((character - baseChar + key) % 26 + baseChar));
                } else {
                    encryptedMessage.append(character);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.encryptMessage(message, key);
    }

    public String decryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, encryptorKey) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (Character character : message.toCharArray()) {
                if (Character.isLetter(character)) {
                    char baseChar = Character.isLowerCase(character) ? 'a' : 'A';
                    encryptedMessage.append((char) ((character - baseChar - key + 26) % 26 + baseChar));
                } else {
                    encryptedMessage.append(character);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.encryptMessage(message, key);
    }

    public void sendMessage(Droid droidRecipient, String message, int key) {
        String encryptedMessage = encryptMessage(message, key);
        System.out.println("Droid " + name + " send encrypted message: " + encryptedMessage);
        droidRecipient.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String message, int key) {
        String decryptedMessage = decryptMessage(message, key);
        System.out.println("Droid " + name + " receive decrypted message: " + decryptedMessage);
    }
}
