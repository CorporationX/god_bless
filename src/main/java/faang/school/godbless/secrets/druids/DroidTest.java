package faang.school.godbless.secrets.druids;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DroidTest {

    Droid r2d2;

    @BeforeEach
    void setUp() {
        r2d2 = new Droid();
    }

    @Test
    @DisplayName("Тестирование отправки зашифрованных сообщения")
    void testSendEncryptedMessage() {
        String message = "abc";
        int key = 1;
        String expectedMessage = "bcd";

        String encryptedMessage = r2d2.sendEncryptedMessage(message, key);

        assertEquals(expectedMessage, encryptedMessage);
    }

    @Test
    @DisplayName("Тестирование приема зашифрованных сообщений")
    void testReceiveEncryptedMessage() {
        String message = "bcd";
        int key = 1;
        String expectedMessage = "abc";

        String encryptedMessage = r2d2.receiveEncryptedMessage(message, key);

        assertEquals(expectedMessage, encryptedMessage);
    }

}