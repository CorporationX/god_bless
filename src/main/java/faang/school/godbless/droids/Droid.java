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

    private final int CAPITAL_A = 65;
    private final int CAPITAL_Z = 90;
    private final int LETTER_A = 97;
    private final int LETTER_Z = 122;

    public String sendEncryptedMessage(String message, int key) {

        DroidMessageEncryptor droidMessageEncryptor = (incomingMessage, shift) -> {
            StringBuilder shiftedString = new StringBuilder();

            for (char ch : incomingMessage.toCharArray()) {
                if (Character.isUpperCase(ch)) {
                    shiftedString.append((char) ('A' + (ch - 'A' + shift) % 26));
                } else if (Character.isLowerCase(ch)) {
                    shiftedString.append((char) ('a' + (ch - 'a' + shift) % 26));
                } else {
                    shiftedString.append(ch);
                }
            }

            return shiftedString.toString();
        };

        return droidMessageEncryptor.encryptDecryptMessage(message, key);
    }

    public String receiveEncryptedMessage(String encryptedMessage, int key) {

        DroidMessageEncryptor droidMessageDecrypt = (incomingMessage, shift) -> {
            StringBuilder shiftedString = new StringBuilder();

            for (char ch : incomingMessage.toCharArray()) {
                if (Character.isUpperCase(ch)) {
                    shiftedString.append((char) ('Z' + (ch - 'Z' - shift) % 26));
                } else if (Character.isLowerCase(ch)) {
                    shiftedString.append((char) ('z' + (ch - 'z' - shift) % 26));
                } else {
                    shiftedString.append(ch);
                }
            }

            return shiftedString.toString();
        };

        return droidMessageDecrypt.encryptDecryptMessage(encryptedMessage, key);
    }
}
