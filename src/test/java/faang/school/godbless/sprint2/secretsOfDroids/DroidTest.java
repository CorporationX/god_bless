package faang.school.godbless.sprint2.secretsOfDroids;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DroidTest {

    @Test
    void sendEncryptedMessage() {
        Droid r2d2 = new Droid();
        String message = "May the Force be with you!";
        int encryptionKey = 3;
        String expected = "Pd|#wkh#Irufh#eh#zlwk#|rx$";
        String encryptedMsg = r2d2.sendEncryptedMessage(message, encryptionKey);
        assertEquals(expected, encryptedMsg);
    }

    @Test
    void receiveEncryptedMessage() {
        Droid c3po = new Droid();
        String encryptedMsg = "Pd|#wkh#Irufh#eh#zlwk#|rx$";
        int encryptionKey = 3;
        String expected = "May the Force be with you!";
        String message = c3po.receiveEncryptedMessage(encryptedMsg, encryptionKey);
        assertEquals(expected, message);
    }
}