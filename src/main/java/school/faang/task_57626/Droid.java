package school.faang.task_57626;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class Droid {
    private String name;

    public void sendMessage(@NonNull Droid droid, String message, int key) {
        String encryptedMessage = encryptMessage(message, key);
        System.out.printf("\t%s отправил зашифрованное сообщение: %s\n",
                getName(), encryptedMessage);
        receiveMessage(droid, encryptedMessage, key);
    }

    private void receiveMessage(@NonNull Droid droid, String message, int key) {
        String decryptedMessage = decryptMessage(message, key);
        System.out.printf("\t%s получил расшифрованное сообщение: %s\n",
                droid.getName(), decryptedMessage);
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

    private String decryptMessage(String message, int key) {
        DroidMessageEncryptor decrypted = (msg, decryptionKey) -> {
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
        return decrypted.encrypt(message, key);
    }
}
