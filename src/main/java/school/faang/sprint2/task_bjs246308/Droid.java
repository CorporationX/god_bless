package school.faang.sprint2.task_bjs246308;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Droid {
    private String name;

    public void sendMessage(String nameSender, Droid droidReceiver, String message, int key) {
        String encryptedMessage = encryptMessage(message, key);
        System.out.println(nameSender + " отправил зашифрованное сообщение: " + encryptedMessage);
        receiveMessage(droidReceiver, encryptedMessage, key);
    }

    public void receiveMessage(Droid droidReceiver, String message, int key) {
        String decryptedMessage = decryptMessage(message, key);
        System.out.println(droidReceiver.getName() + " получил расшифрованное сообщение: " + decryptedMessage);
    }

    private String encryptMessage(String message, int key) {
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
        return encryptor.encrypt(message, key);
    }

    private String decryptMessage(String encryptedMessage, int key) {
        DroidMessageEncryptor decryptor = (msg, decryptionKey) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    decryptedMessage.append((char) ((ch - base - decryptionKey + 26) % 26 + base));
                } else {
                    decryptedMessage.append(ch);
                }
            }
            return decryptedMessage.toString();
        };
        return decryptor.encrypt(encryptedMessage, key);
    }

}
