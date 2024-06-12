package faang.school.godbless.module1.sprint2.task10;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Droid {
    String name;
    String message;

    public void sendEncryptedMessage(Droid droid, String message, Integer key) {
        DroidMessageEncryptor<String, Integer, String> dme = this::coderMessage;
        droid.setMessage(dme.encrypt(message, key));
    }

    public String coderMessage(String message, Integer key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                ch = (char) ((ch - base + key) % 26 + base);
            }
            result.append(ch);
        }
        return result.toString();
    }
}
