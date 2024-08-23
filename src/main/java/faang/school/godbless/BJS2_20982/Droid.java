package faang.school.godbless.BJS2_20982;

import lombok.Getter;

@Getter
public class Droid {

    private String message;
    private int key;

    public String sendEncryptedMessage(String message, Integer key) {
        DroidMessageEncryptor encryptor = this::shiftMessage;
        return encryptor.encrypt(message, key);
    }

    public String receiveEncryptedMessage(String encryptedMsg, Integer key) {
        DroidMessageEncryptor decryptor = (msg, k) -> shiftMessage(msg, -k);
        ;
        return decryptor.encrypt(encryptedMsg, key);
    }

    private String shiftMessage(String message, int key) {
        StringBuilder result = new StringBuilder();
        for (char ch : message.toCharArray()) {
            char shiftedChar = ch;
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                shiftedChar = (char) ((ch - base + key + 26) % 26 + base);
            }
            result.append(shiftedChar);
        }
        return result.toString();
    }
}
