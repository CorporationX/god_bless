package school.faang.BJS2_57521;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class Droid {
    private static final int ALPHABET_SIZE = 26;
    private final String name;
    private static final DroidMessageEncryptor ENCRYPTOR = (message, key) -> {
        StringBuilder encryptedMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                ch = (char) ((ch + key - base) % ALPHABET_SIZE + base);
            }
            encryptedMessage.append(ch);
        }
        return encryptedMessage.toString();
    };

    private String encryptMessage(@NonNull String message, int key) {
        return ENCRYPTOR.encrypt(message, key);
    }

    private String decryptMessage(@NonNull String message, int key) {
        return encryptMessage(message, ALPHABET_SIZE - key);
    }

    public void sendMessage(@NonNull Droid droid, @NonNull String message, int key) {
        String encryptedMessage = encryptMessage(message, key);
        System.out.printf("%s отправил зашифрованное сообщение: %s\n", name, encryptedMessage);
        droid.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(@NonNull String message, int key) {
        String decryptedMessage = decryptMessage(message, key);
        System.out.printf("%s получил расшифрованное сообщение: %s\n", name, decryptedMessage);
    }
}
