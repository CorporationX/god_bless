package faang.school.godbless.secondsprint.droids;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DroidTest {
    private Droid c3po;
    private Droid r2d2;
    private String message;
    private int key;

    @BeforeEach
    public void setUp() {
        c3po = new Droid();
        r2d2 = new Droid();
        message = "Hello, World!";
    }

    @Test
    @DisplayName("Should correctly encrypt message with given key")
    public void testSendEncryptedMessage() {
        key = 3;
        String expectedEncryptedMessage = "Khoor, Zruog!";
        String encryptedMessage = c3po.sendEncryptedMessage(message, key);

        assertEquals(expectedEncryptedMessage, encryptedMessage);
    }

    @Test
    @DisplayName("Should correctly decrypt encrypted message with given key")
    public void testReceiveEncryptedMessage() {
        key = 5;
        String encryptedMessage = "Mjqqt, Btwqi!";
        String expectedDecryptedMessage = "Hello, World!";
        String decryptedMessage = r2d2.receiveEncryptedMessage(encryptedMessage, key);

        assertEquals(expectedDecryptedMessage, decryptedMessage);
    }

    @Test
    @DisplayName("Should correctly process message consisting of non letter characters")
    public void testSendAndReceiveEncryptedMessageWithNonLetterCharacters() {
        key = 7;
        String originalMessage = "12345 !@#$%";

        String encryptedMessage = c3po.sendEncryptedMessage(originalMessage, key);
        String decryptedMessage = r2d2.receiveEncryptedMessage(encryptedMessage, key);

        assertAll(
                () -> assertEquals(originalMessage, encryptedMessage),
                () -> assertEquals(originalMessage, decryptedMessage)
        );
    }
}
