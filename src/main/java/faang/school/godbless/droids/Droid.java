package faang.school.godbless.droids;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Droid {

    private static final int ALPHABET_SIZE = 26;

    public String encrypt(String message, int key) {
        return process(message, key);
    }

    public String decrypt(String encryptedMessage, int key) {
        return process(encryptedMessage, -key);
    }

    private String process(String message, int key) {
        DroidMessageEncryptor droidMessageEncryptor = (incomingMessage, shift) -> {

            StringBuilder result = new StringBuilder();

            for (char ch : message.toCharArray()) {
                if (Character.isUpperCase(ch)) {
                    result.append(shift(ch, key, 'A'));
                } else if (Character.isLowerCase(ch)) {
                    result.append(shift(ch, key, 'a'));
                } else {
                    result.append(ch);
                }
            }

            return result.toString();
        };

        return droidMessageEncryptor.encryptDecryptMessage(message, key);
    }

    private char shift(char ch, int key, char baseChar) {
        int offset = (ch - baseChar + key + ALPHABET_SIZE) % ALPHABET_SIZE;
        return (char) (baseChar + offset);
    }
}
