package faang.school.godbless.secretsOfDroid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DroidTest {
    private Droid r2d2;
    private Droid c3po;
    private String originalMsg;
    private int encryptionKey;

    @BeforeEach
    void setUp(){
        r2d2 = new Droid("r2d2");
        c3po = new Droid("c3po");
        originalMsg = "May the Force be with you!";
        encryptionKey = 10;
    }

    @Test
    void testSendEncryptedMessage() {
        String expected = "klm";
        String encryptedMsg = r2d2.sendEncryptedMessage("abc", encryptionKey);
        assertEquals(expected, encryptedMsg);
    }

    @Test
    void testReceiveEncryptedMessage() {
        String encryptedMsg = r2d2.sendEncryptedMessage(originalMsg, encryptionKey);
        assertEquals(originalMsg, c3po.receiveEncryptedMessage(encryptedMsg, encryptionKey));
    }
}