package faang.school.godbless.lambda.droids;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Droid {
    private static final DroidMessageEncryptor ENCRYPTOR = (m, k) -> {
        var sb = new StringBuilder();
        for (var ch : m.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                sb.append((char) ((ch - base + k) % 26 + base));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    };

    private static final DroidMessageEncryptor DECRYPTOR = (m, k) -> {
        var sb = new StringBuilder();
        for (var ch : m.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                sb.append((char) ((ch - base - k + 26) % 26 + base));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    };

    private String name;

    public void sendMessage(Droid receiver, String message, int key) {
        var encryptedMessage = encryptMessage(message, key);
        receiver.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String message, int key) {
        var decryptedMessage = decryptMessage(message, key);
        System.out.println(decryptedMessage);
    }


    private String encryptMessage(String message, int key) {
        return ENCRYPTOR.encrypt(message, key);
    }

    private String decryptMessage(String message, int key) {
        return DECRYPTOR.encrypt(message, key);
    }

}
