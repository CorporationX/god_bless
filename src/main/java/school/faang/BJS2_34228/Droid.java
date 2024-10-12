package school.faang.BJS2_34228;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Droid {
    private static final int ENGLISH_ALPHABET_LENGTH = 26;

    private String name;

    public void sendMessage(Droid recipient, String message, int key) {
        String encryptedMessage = encryptMessage(message, key);
        System.out.println(this.name + " отправил зашифрованное сообщение " + encryptedMessage);

        receiveMessage(encryptedMessage, key, recipient);

    }

    private void receiveMessage(String message, int key, Droid recipient) {
        String decryptedMessage = decryptMessage(message, key);
        System.out.println(recipient.getName() + " получил расшифрованное сообщение " + decryptedMessage);
    }

    private String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, encryptionKey) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    encryptedMessage.append((char) ((ch - base + encryptionKey) % ENGLISH_ALPHABET_LENGTH + base));
                } else {
                    encryptedMessage.append(ch);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.encrypt(message, key);
    }

    private String decryptMessage(String encryptedMessage, int key) {
        return encryptMessage(encryptedMessage, ENGLISH_ALPHABET_LENGTH - (key % ENGLISH_ALPHABET_LENGTH));
    }
}
