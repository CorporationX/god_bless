package school.faang.droid.secrets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DroidTest {
    private Droid r2d2;
    private Droid c3po;
    private Droid bb8;

    private String message1;
    private String message2;
    private String message3;
    private int encryptionKey1;
    private int encryptionKey2;

    @BeforeEach
    public void setUp() {
        r2d2 = new Droid("R2D2");
        c3po = new Droid("C3PO");
        bb8 = new Droid("BB-8");

        message1 = "Join the Rebellion!";
        message2 = "The Death Star is operational!";
        message3 = "The mission is complete.";
        encryptionKey1 = 3;
        encryptionKey2 = 7;
    }

    @Test
    public void sendEncryptedMessageR2dpTest() {
        String expected = "Mrlq wkh Uhehoolrq!";
        String encryptedMessage = r2d2.sendMessage(c3po, message1, encryptionKey1);
        assertEquals(expected, encryptedMessage);
    }

    @Test
    public void receivedDecryptedMessageR2dpTest() {
        String encryptedMessage = r2d2.sendMessage(c3po, message1, encryptionKey1);
        String decryptedMessage = c3po.receiveMessage(encryptedMessage, encryptionKey1);
        assertEquals(message1, decryptedMessage);
    }

    @Test
    public void sendEncryptedMessageC3poTest() {
        String expected = "Aol Klhao Zahy pz vwlyhapvuhs!";
        String encryptedMessage = c3po.sendMessage(r2d2, message2, encryptionKey2);
        assertEquals(expected, encryptedMessage);
    }

    @Test
    public void receivedDecryptedMessageC3poTest() {
        String encryptedMessage = c3po.sendMessage(r2d2, message2, encryptionKey2);
        String decryptedMessage = r2d2.receiveMessage(encryptedMessage, encryptionKey2);
        assertEquals(message2, decryptedMessage);
    }

    @Test
    public void sendEncryptedMessageBb8Test() {
        String expected = "Aol tpzzpvu pz jvtwslal.";
        String encryptedMessage = bb8.sendMessage(c3po, message3, encryptionKey2);
        assertEquals(expected, encryptedMessage);
    }

    @Test
    public void receivedDecryptedMessageBb8Test() {
        String encryptedMessage = bb8.sendMessage(c3po, message3, encryptionKey2);
        String decryptedMessage = c3po.receiveMessage(encryptedMessage, encryptionKey2);
        assertEquals(message3, decryptedMessage);
    }
}
