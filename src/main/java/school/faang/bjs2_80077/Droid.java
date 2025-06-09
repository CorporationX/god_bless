package school.faang.bjs2_80077;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Droid {
    private String name;

    String encryptMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (msg, key) -> {
            StringBuilder encryptedMessage = new StringBuilder();

            for (int i = 0; i < message.length(); i++) {
                char ch = message.charAt(i);
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    encryptedMessage.append((char) ((ch - base + key) % 26 + base));
                } else {
                    encryptedMessage.append(ch);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.encrypt(message, encryptionKey);
    }


    String decryptMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (msg, key) -> {
            StringBuilder decryptedMessage = new StringBuilder();

            for (int i = 0; i < message.length(); i++) {
                char ch = message.charAt(i);
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    decryptedMessage.append((char) ((ch - base - key + 26) % 26 + base));
                } else {
                    decryptedMessage.append(ch);
                }
            }
            return decryptedMessage.toString();
        };
        return encryptor.encrypt(message, encryptionKey);
    }

    void receiveMessage(String encryptedMessage, int encryptionKey) {
        String decryptedMessage = decryptMessage(encryptedMessage, encryptionKey);
        System.out.println(name + " получил расшифрованное сообщение: " + decryptedMessage);
    }

    void sendMessage(Droid recipientDroid, String message, int encryptionKey) {
        String encryptedMessage = encryptMessage(message, encryptionKey);
        System.out.println(name + " отправил зашифрованное сообщение: " + encryptedMessage);
        recipientDroid.receiveMessage(encryptedMessage, encryptionKey);
    }
}
