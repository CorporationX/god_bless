package school.faang.task_46528;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.BiFunction;

@RequiredArgsConstructor
@Getter
public class Droid {
    private static final int COUNT_LETTERS_ALPHABET = 26;
    private final String name;

    public void sendMessage(Droid droid, String message, int key) {
        String decryptedMessage = droid.encryptMessage(message, key);
        System.out.println(droid.getName() + " отправил зашифрованное сообщение: "
                + decryptedMessage);
        receiveMessage(decryptedMessage, key, droid);
    }

    public void receiveMessage(String message, int key, Droid droid) {
        String decryptedMessage = droid.decryptMessage(message, key);
        System.out.println(droid.getName() + " получил расшифрованное сообщение: "
                + decryptedMessage);
    }

    private String encryptMessage(String message, int key) {
        return getMessageAfterCaesarCipher(message, key,
                (ch, base) -> (char) ((ch - base + key) % COUNT_LETTERS_ALPHABET + base));
    }

    private String decryptMessage(String message, int key) {
        return getMessageAfterCaesarCipher(message, key,
                (ch, base) -> (char) ((ch - base - key + COUNT_LETTERS_ALPHABET) % COUNT_LETTERS_ALPHABET + base));
    }

    private String getMessageAfterCaesarCipher(String message, int key,
                                               BiFunction<Character, Character, Character> cipher) {
        StringBuilder builder = new StringBuilder();
        DroidMessageEncryptor droidMessageEncryptor = (m, k) -> {
            for (char ch : m.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    builder.append(cipher.apply(ch, base));
                } else {
                    builder.append(ch);
                }
            }
            return builder.toString();
        };

        return droidMessageEncryptor.encrypt(message, key);
    }
}
