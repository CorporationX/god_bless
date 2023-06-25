package faang.school.godbless.kxnvg.starwars;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Droid {

    private String droidMessage;

    public void sendEncryptedMessage(Droid droid, String message, int key) {
        if (key <= 0) {
            throw new IllegalArgumentException("Ключ шифрование должен быть больше 0");
        }

        DroidMessageEncryptor messageEncryptor = (tempMessage, tempKey) -> {
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < tempMessage.length(); i++) {
                char ch = tempMessage.charAt(i);
                if (Character.isLetter(ch) || Character.isDigit(ch)) {
                    char tempChar = (char) (ch + tempKey);
                    builder.append(tempChar);
                } else {
                    builder.append(ch);
                }
            }
            return builder.toString();
        };
        droid.setDroidMessage(messageEncryptor.encryption(message, key));
    }
}
