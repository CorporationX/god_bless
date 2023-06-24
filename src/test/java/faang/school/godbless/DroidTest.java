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
        message = "abc";
        var encryptedMessage = r2d2.sendEncryptedMessage(message, encryptionKey, (mes, key) -> {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < mes.length(); i++) {
                result.append((char) (mes.charAt(i) + key));
            }
            return result.toString();
        });
        assertEquals(encryptedMessage, "bcd");
    }

    @Test
    void testDecryption() {
        message = "bcd";
        var encryptedMessage = r2d2.receiveEncryptedMessage(message, encryptionKey, (mes, key) -> {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < mes.length(); i++) {
                result.append((char) (mes.charAt(i) - key));
            }
            return result.toString();
        });
        assertEquals(encryptedMessage, "abc");
    }
}