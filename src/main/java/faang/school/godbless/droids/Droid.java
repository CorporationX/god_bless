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
                if (ch >= CAPITAL_A && ch <= CAPITAL_Z && ch + shift > CAPITAL_Z) {
                    shiftedString.append((char) (CAPITAL_A + (ch + shift - CAPITAL_Z - 1)));
                } else if (ch >= LETTER_A && ch <= LETTER_Z && ch + shift > LETTER_Z) {
                    shiftedString.append((char) (LETTER_A + (ch + shift - LETTER_Z - 1)));
                } else {
                    shiftedString.append((char) (ch + shift));
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
                if (ch >= CAPITAL_A && ch <= CAPITAL_Z && ch - shift < CAPITAL_A) {
                    shiftedString.append((char) (CAPITAL_Z + (CAPITAL_A - ch - shift + 1)));
                } else if (ch >= LETTER_A && ch <= LETTER_Z && ch - shift < LETTER_A) {
                    shiftedString.append((char) (LETTER_Z + (LETTER_A - ch - shift + 1)));
                } else {
                    shiftedString.append((char) (ch - shift));
                }
            }

            return shiftedString.toString();
        };

        return droidMessageDecrypt.encryptDecryptMessage(encryptedMessage, key);
    }
}
