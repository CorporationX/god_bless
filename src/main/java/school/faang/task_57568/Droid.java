package school.faang.task_57568;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
public class Droid {
    private static final int LATIN_LETTERS_COUNT = 26;
    private static final char FIRST_UPPERCASE_LETTER = 'A';
    private static final char FIRST_LOWERCASE_LETTER = 'a';

    private final String name;

    private String encryptMessage(@NonNull String message, int key) {
        DroidMessageEncryptor encryptor = (msg, encryptKey) -> {
            StringBuilder encryptMessage = new StringBuilder();
            for (char symbol : msg.toCharArray()) {
                if (Character.isLetter(symbol)) {
                    char base = Character.isLowerCase(symbol) ? FIRST_LOWERCASE_LETTER : FIRST_UPPERCASE_LETTER;
                    encryptMessage.append((char) ((symbol - base + encryptKey) % LATIN_LETTERS_COUNT + base));
                } else {
                    encryptMessage.append(symbol);
                }
            }
            return encryptMessage.toString();
        };
        return encryptor.processing(message, key);
    }

    private String decryptMessage(@NonNull String encryptedMessage, int key) {
        DroidMessageEncryptor decryptor = (msg, decryptionKey) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? FIRST_LOWERCASE_LETTER : FIRST_UPPERCASE_LETTER;
                    decryptedMessage.append(
                            (char) ((ch - base - decryptionKey + LATIN_LETTERS_COUNT) % LATIN_LETTERS_COUNT + base)
                    );
                } else {
                    decryptedMessage.append(ch);
                }
            }
            return decryptedMessage.toString();
        };
        return decryptor.processing(encryptedMessage, key);
    }

    public void sendMessage(@NonNull Droid droid, @NonNull String message, int key) {
        String encryptMessage = encryptMessage(message, key);
        System.out.printf("%s отправил %s зашифрованное сообщение: %s%n",
                getName(), droid.getName(), encryptMessage);
        droid.receiveMessage(encryptMessage, key);
    }

    private void receiveMessage(@NonNull String encryptMessage, int key) {
        System.out.printf("%s получил зашифрованное сообщение: %s%n", getName(), decryptMessage(encryptMessage, key));
    }
}
