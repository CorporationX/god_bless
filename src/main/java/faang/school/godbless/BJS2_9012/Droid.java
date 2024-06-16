package faang.school.godbless.BJS2_9012;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Droid {
    private String message;
    private int key;

    public String sendEncryptedMessage(String message, int key) {
        DroidMessageEncrypter droidMessageEncrypter = (m, k) -> {
            char[] chars = m.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                chars[i] = (char) (chars[i] + key);
            }
            return new String(chars);
        };
        String encryptedMessage = droidMessageEncrypter.encrypt(message, key);
        this.message = encryptedMessage;
        this.key = key;
        return encryptedMessage;
    }

    public String receiveEncryptedMessage(String message, int key) {
        DroidMessageEncrypter droidMessageEncrypter = (m, k) -> {
            char[] chars = m.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                System.out.println(chars[i]);
                chars[i] = (char) (chars[i] - key);
            }
            return new String(chars);
        };
        return droidMessageEncrypter.encrypt(message, key);
    }
}
