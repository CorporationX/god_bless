package faang.school.godbless;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DroidTest {
    Droid r2d2;
    String message;
    int encryptionKey;

    @BeforeEach
    void setUp() {
        r2d2 = new Droid();
        encryptionKey = 1;
    }

    @Test
    void testEncryption() {
        message = "AaZz1_";
        var encryptedMessage = r2d2.sendEncryptedMessage(message, encryptionKey, (mes, key) -> {
            StringBuilder result = new StringBuilder();
            char currentChar;
            for (int i = 0; i < mes.length(); i++) {
                currentChar = mes.charAt(i);
                if (Character.toLowerCase(currentChar) >= 97 && Character.toLowerCase(currentChar) <= 122) {
                    currentChar += key;
                }
                if ("zZ".contains(String.valueOf((char) (currentChar - 1)))) {
                    currentChar -= 26;
                }
                result.append(currentChar);
            }
            return result.toString();
        });
        assertEquals(encryptedMessage, "BbAa1_");
    }

    @Test
    void testDecryption() {
        message = "AazZ1_0";
        var encryptedMessage = r2d2.receiveEncryptedMessage(message, encryptionKey, (mes, key) -> {
            StringBuilder result = new StringBuilder();
            char currentChar;
            for (int i = 0; i < mes.length(); i++) {
                currentChar = mes.charAt(i);
                if (Character.toLowerCase(currentChar) >= 97 && Character.toLowerCase(currentChar) <= 122) {
                    currentChar -= key;
                }
                if ("Aa".contains(String.valueOf((char) (currentChar + 1)))) {
                    currentChar += 26;
                }
                result.append(currentChar);
            }
            return result.toString();
        });
        assertEquals(encryptedMessage, "ZzyY1_0");
    }
}