package faang.school.godbless.droids;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DroidTest {

    final Droid R2D2 = new Droid();
    final String MESSAGE_DECRYPTED = "ABCabcXYZxyz";
    final String MESSAGE_ENCRYPTED = "BCDbcdYZAyza";
    int encryptionKey = 1;

    @Test
    void sendEncryptedMessageTest() {
        assertEquals(MESSAGE_ENCRYPTED, R2D2.sendEncryptedMessage(MESSAGE_DECRYPTED, encryptionKey));
    }

    @Test
    void receiveEncryptedMessageTest() {
        assertEquals(MESSAGE_DECRYPTED, R2D2.receiveEncryptedMessage(MESSAGE_ENCRYPTED, encryptionKey));
    }
}