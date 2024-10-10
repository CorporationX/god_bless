package school.faang.droidsecrets;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class Droid {

    private static final int ALPHABET_SIZE = 26;

    private String name;

    public void sendMessage(Droid receiver, String message, int key) {
        Objects.requireNonNull(message, "Message cannot be null");
        Objects.requireNonNull(receiver, "Receiver cannot be null");
        key = Math.abs(key);

        String encryptedMessage = encryptMessage(message, key);
        System.out.println(name + " sent encrypted message: " + encryptedMessage);
        receiver.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String message, int key) {
        Objects.requireNonNull(message, "Message cannot be null");
        key = Math.abs(key);

        String decryptedMessage = decryptMessage(message, key);
        System.out.println(name + " received decrypted message: " + decryptedMessage);
    }

    private String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (m, k) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char ch : m.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char start = Character.isUpperCase(ch) ? 'A' : 'a';
                    ch = (char) ((ch - start + k) % ALPHABET_SIZE + start);
                }
                encryptedMessage.append(ch);
            }
            return encryptedMessage.toString();
        };

        return encryptor.encrypt(message, key);
    }

    private String decryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (m, k) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char ch : m.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char start = Character.isUpperCase(ch) ? 'A' : 'a';
                    int shift = (ch - start - k) % ALPHABET_SIZE;
                    ch = (char) (shift < 0 ? shift + ALPHABET_SIZE + start : shift + start);
                }
                encryptedMessage.append(ch);
            }
            return encryptedMessage.toString();
        };

        return encryptor.encrypt(message, key);
    }
}
