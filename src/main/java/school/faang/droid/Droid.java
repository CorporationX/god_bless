package school.faang.droid;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class Droid {
    private String name;
    private static final int ALPHABET_LENGTH = 26;
    private static final char LOWERCASE_A = 'a';
    private static final char UPPERCASE_A = 'A';

    private String processMessage(String message, int key, boolean encrypt) {
        return message.chars().mapToObj(ch -> (char) ch).map(ch -> {
                    if (Character.isLetter(ch)) {
                        char base = Character.isLowerCase(ch) ? LOWERCASE_A : UPPERCASE_A;
                        int shift = encrypt ? key : -key;
                        return (char) ((ch - base + shift + ALPHABET_LENGTH) % ALPHABET_LENGTH + base);
                    }
                    return ch;
                })
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public String encryptMessage(String message, int key) {
        return processMessage(message, key, true);

    }

    public String decryptMessage(String encryptedMessage, int key) {
        return processMessage(encryptedMessage, key, false);
    }

    public void sendMessage(Droid recipient, String message, int key) {
        String encryptedMessage = encryptMessage(message, key);
        System.out.printf("%s sent an encrypted message: %s%n", name, encryptedMessage);
        recipient.receivedMessage(encryptedMessage, key);
    }

    public void receivedMessage(String encryptedMessage, int key) {
        String decryptedMessage = decryptMessage(encryptedMessage, key);
        System.out.println(String.format("%s received a decrypted message: %s%n", name, decryptedMessage));
    }
}
