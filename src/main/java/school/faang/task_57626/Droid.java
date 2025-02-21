package school.faang.task_57626;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class Droid {
    private static final char LOWERCASE_A = 'a';
    private static final char UPPERCASE_A = 'A';
    private static final int ALPHABET_LENGTH = 26;

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
        return processMessage(message, key);
    }

    private String decryptMessage(String message, int key) {
        return processMessage(message, -key);
    }

    private String processMessage(String message, int key) {
        StringBuilder result = new StringBuilder();
        for (char ch : message.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? LOWERCASE_A : UPPERCASE_A;
                result.append((char) ((ch - base + key + ALPHABET_LENGTH) % ALPHABET_LENGTH + base));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
