package school.faang.task57538.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Droid {
    private String message;
    private Integer key;

    public String encryptMessage(String message, Integer key) {
        DroidMessageEncryptor encryptor = (msgE, keyE) -> {
            StringBuilder strEnc = new StringBuilder();
            for (char ch : msgE.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    strEnc.append((char) ((ch - base + keyE) % 26 + base));
                } else {
                    strEnc.append(ch);
                }
            }
            return strEnc.toString();
        };
        return encryptor.encrypt(message, key);
    }

    public String sendMessage(Droid droid, String message, int key) {
        return droid.encryptMessage(message, key);
    }

    public String decryptMessage(String message, int key) {
        DroidMessageEncryptor decryptor = (msgE, keyD) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char ch : msgE.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    decryptedMessage.append((char) ((ch - base - keyD + 26) % 26 + base));
                } else {
                    decryptedMessage.append(ch);
                }
            }
            return decryptedMessage.toString();
        };
        return decryptor.encrypt(message, key);
    }

    public String receiveMessage(Droid droid, String message, int key) {
        return droid.decryptMessage(message, key);
    }

    public Droid(String message) {
        this.message = message;
    }
}
