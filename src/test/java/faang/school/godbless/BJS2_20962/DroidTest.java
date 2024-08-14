package faang.school.godbless.BJS2_20962;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DroidTest {

    Droid droid = new Droid();
    String originalMessage = "May the Force be with you!";
    String encryptedMessage = "guS NBy ZILwy vy QCNB SIO!";
    Integer key = 20;

    @Test
    void sendEncryptedMessageTest() {
        String actual = droid.sendEncryptedMessage(originalMessage, key);

        assertEquals(encryptedMessage, actual);
    }

    @Test
    void receiveEncryptedMessageTest() {
        String actual = droid.receiveEncryptedMessage(encryptedMessage, key);

        assertEquals(originalMessage, actual);
    }
}