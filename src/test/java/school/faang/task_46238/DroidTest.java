package school.faang.task_46238;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DroidTest {
    private static final int encryptionKey1 = 3;
    private static final int encryptionKey2 = 7;
    private Droid r2d2;
    private Droid c3po;
    private String message1;
    private String encryptedMessage1;
    private String encryptedMessage2;
    private String message2;

    @BeforeEach
    void setUp() {
        r2d2 = new Droid("R2D2");
        c3po = new Droid("C3PO");
        message1 = "Join the Rebellion!";
        message2 = "The Death Star is operational!";
        encryptedMessage1 = "Mrlq wkh Uhehoolrq!";
        encryptedMessage2 = "Aol Klhao Zahy pz vwlyhapvuhs!";
    }

    @Test
    void testSuccessSendMessage() {
        assertDoesNotThrow(() -> r2d2.sendMessage(c3po, message1, encryptionKey1));
    }

    @Test
    void testSendMessageThrowException() {
        assertThrows(IllegalArgumentException.class, () -> r2d2.sendMessage(c3po, "", encryptionKey1));
        assertThrows(IllegalArgumentException.class, () -> r2d2.sendMessage(c3po, null, encryptionKey1));
        assertThrows(IllegalArgumentException.class, () -> r2d2.sendMessage(null, "", encryptionKey1));
    }

    @Test
    void testSuccessReceiveMessage() {
        assertDoesNotThrow(() -> r2d2.receiveMessage(message1, encryptionKey1));
    }

    @Test
    void testReceiveMessageThrowException() {
        assertThrows(IllegalArgumentException.class, () -> r2d2.receiveMessage("", encryptionKey1));
        assertThrows(IllegalArgumentException.class, () -> r2d2.receiveMessage(null, encryptionKey1));
    }

    @Test
    void testSuccessEncryptMessage() {
        assertEquals(encryptedMessage1, Droid.encryptMessage(message1, encryptionKey1));
        assertEquals(encryptedMessage2, Droid.encryptMessage(message2, encryptionKey2));
        assertEquals("111", Droid.encryptMessage("111", encryptionKey1));
        assertEquals("ddd", Droid.encryptMessage("aaa", encryptionKey1));
        assertEquals("DDD", Droid.encryptMessage("AAA", encryptionKey1));
        assertEquals("AaA", Droid.encryptMessage("AaA", 26));
        assertEquals("BBB", Droid.encryptMessage("AAA", 27));
        assertEquals("AAA", Droid.encryptMessage("AAA", 0));
    }

    @Test
    void testEncryptMessageThrowException() {
        assertThrows(IllegalArgumentException.class, () -> Droid.encryptMessage("", encryptionKey1));
        assertThrows(IllegalArgumentException.class, () -> Droid.encryptMessage(null, encryptionKey1));
    }

    @Test
    void testSuccessDecryptMessage() {
        assertEquals(message1, Droid.decryptMessage(encryptedMessage1, encryptionKey1));
        assertEquals("111", Droid.decryptMessage("111", encryptionKey1));
        assertEquals("aaa", Droid.decryptMessage("ddd", encryptionKey1));
        assertEquals("AAA", Droid.decryptMessage("DDD", encryptionKey1));
        assertEquals("AaA", Droid.decryptMessage("AaA", 26));
        assertEquals("AAA", Droid.decryptMessage("BBB", 27));
        assertEquals("AAA", Droid.decryptMessage("AAA", 0));
    }

    @Test
    void testDecryptMessageThrowException() {
        assertThrows(IllegalArgumentException.class, () -> Droid.decryptMessage("", encryptionKey1));
        assertThrows(IllegalArgumentException.class, () -> Droid.decryptMessage(null, encryptionKey1));
    }

    @Test
    void testSuccessCreateDroid() {
        assertDoesNotThrow(() -> new Droid("test name"));
    }

    @Test
    void testFailCreateDroid() {
        assertThrows(IllegalArgumentException.class, () -> new Droid(""));
        assertThrows(IllegalArgumentException.class, () -> new Droid(null));
    }
}