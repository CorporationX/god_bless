package faang.school.godbless;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DroidTest {

    @Test
    void testSendEncryptedMessage() {
        Droid droid = new Droid();
        String message = "May the Force be with you!";
        int encryptionKey = 3;

        String encryptedMsg = droid.sendEncryptedMessage(message, encryptionKey);
        assertEquals("Pdb wkh Irufh eh zlwk brx!", encryptedMsg);
    }

    @Test
    void testReceiveEncryptedMessage() {
        Droid droid = new Droid();
        String encryptedMessage = "Pdb wkh Irufh eh zlwk brx!";
        int encryptionKey = 3;

        String decryptedMsg = droid.receiveEncryptedMessage(encryptedMessage, encryptionKey);
        assertEquals("May the Force be with you!", decryptedMsg);

    }
}