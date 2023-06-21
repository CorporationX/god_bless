package faang.school.godbless.sprint3.droid_secrets;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Droid {
    private String message;

    public void sendEncryptedMessage(Droid droid, String message, int key) {
        DroidMessageEncryptor encryptor = (m, k) -> {
            k = k % 26;
            if (k < 0) {
                k = 26 + k;
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < m.length(); i++) {
                char c = m.charAt(i);
                if (Character.isLowerCase(c)) {
                    c = (char) ((c - 97 + k) % 26 + 97);
                } else if (Character.isUpperCase(c)) {
                    c = (char) ((c - 65 + k) % 26 + 65);
                }
                builder.append(c);
            }
            return builder.toString();
        };
        String encryptedString = encryptor.encryptMessage(message, key);
        droid.setMessage(encryptedString);
    }
}
