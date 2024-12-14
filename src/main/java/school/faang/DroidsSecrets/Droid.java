package school.faang.DroidsSecrets;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Droid {
    private String name;

    public String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, encryptionKey) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    encryptedMessage.append((char) ((ch - base + encryptionKey) % 26 + base));
                } else {
                    encryptedMessage.append(ch);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.act(message, key % 26);

    }

    public String decryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, encryptionKey) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    encryptedMessage.append((char) ((ch - base - encryptionKey + 26) % 26 + base));
                } else {
                    encryptedMessage.append(ch);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.act(message, key % 26);
    }

    public void sendMessage(Droid droid, String message, int key) {
        System.out.println(this.getName() + "Отправил зашифрованное сообщение: " +
                encryptMessage(message, key));
        droid.receiveMessage(encryptMessage(message, key), key);
    }

    public void receiveMessage(String encryptedMessage, int key) {
        System.out.println(this.getName() + "Получил расшифрованное сообщение: " +
                decryptMessage(encryptedMessage, key));
    }
}
