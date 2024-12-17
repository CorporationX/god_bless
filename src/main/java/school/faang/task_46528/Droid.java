package school.faang.task_46528;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

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
        return getMessageAfterCaesarCipher(message, key, getShiftForEncrypt(key));
    }

    private String decryptMessage(String message, int key) {
        return getMessageAfterCaesarCipher(message, key, getShiftForDecrypt(key));
    }

    private String getMessageAfterCaesarCipher(String message, int key, int shift) {
        StringBuilder builder = new StringBuilder();
        DroidMessageEncryptor droidMessageEncryptor = (m, k) -> {
            for (char ch : m.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    builder.append((char) ((ch - base + shift) % COUNT_LETTERS_ALPHABET + base));
                } else {
                    builder.append(ch);
                }
            }
            return builder.toString();
        };

        return droidMessageEncryptor.encrypt(message, key);
    }

    private int getShiftForDecrypt(int key) {
        return -key + COUNT_LETTERS_ALPHABET;
    }

    private int getShiftForEncrypt(int key) {
        return key;
    }
}
