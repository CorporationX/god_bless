package school.faang.task_57568;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class Droid {
    private static final int LATIN_LETTERS_COUNT = 26;
    private static final char FIRST_UPPERCASE_LETTER = 'A';
    private static final char FIRST_LOWERCASE_LETTER = 'a';

    private final String name;

    private String encryptMessage(@NonNull String message, int key) {
        DroidMessageEncryptor encryptor = (msg, encryptKey)
                -> messageProcessing(msg, encryptKey, true);
        return encryptor.processing(message, key);
    }

    private String decryptMessage(@NonNull String encryptedMessage, int key) {
        DroidMessageEncryptor decryptor = (msg, decryptionKey)
                -> messageProcessing(msg, decryptionKey, false);
        return decryptor.processing(encryptedMessage, key);
    }

    public void sendMessage(@NonNull Droid droid, @NonNull String message, int key) {
        String encryptMessage = encryptMessage(message, key);
        System.out.printf("%s отправил %s зашифрованное сообщение: %s%n",
                getName(), droid.getName(), encryptMessage);
        droid.receiveMessage(encryptMessage, key);
    }

    public void receiveMessage(@NonNull String encryptMessage, int key) {
        System.out.printf("%s получил зашифрованное сообщение: %s%n", getName(), decryptMessage(encryptMessage, key));
    }

    private String messageProcessing(@NonNull String message, int key, boolean isEncryption) {
        return message.chars()
                .map(codePoint -> {
                    if (Character.isLetter(codePoint)) {
                        int base = Character.isLowerCase(codePoint) ? FIRST_LOWERCASE_LETTER : FIRST_UPPERCASE_LETTER;
                        return isEncryption
                                ? symbolEncryption(codePoint, base, key) : symbolDecryption(codePoint, base, key);
                    }
                    return codePoint;
                })
                .mapToObj(codePoint -> String.valueOf((char) codePoint))
                .collect(Collectors.joining());
    }

    private int symbolEncryption(int symbol, int base, int key) {
        return (symbol - base + key) % LATIN_LETTERS_COUNT + base;
    }

    private int symbolDecryption(int symbol, int base, int key) {
        return (symbol - base - key + LATIN_LETTERS_COUNT) % LATIN_LETTERS_COUNT + base;
    }
}
