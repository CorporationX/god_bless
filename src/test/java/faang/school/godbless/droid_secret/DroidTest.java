package faang.school.godbless.droid_secret;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DroidTest{

    Droid droid1;
    Droid droid2;

    @BeforeEach
    void setUp(){
        droid1 = new Droid();
        droid2 = new Droid();
    }

    @Test
    void encryptMessageTest(){
        String message = "May the force be with you";
        int key = 3;
        String result = droid1.sendEncryptedMessage(droid2, message, key);
        String expected = "Pd|#wkh#irufh#eh#zlwk#|rx";

        Assertions.assertEquals(expected, result);
    }

    @Test
    void decryptMessageTest(){
        String message = "Pd|#wkh#irufh#eh#zlwk#|rx";
        int key = 3;
        String result = DroidMessageReceiver.receiveEncryptedMessage(message, key);
        String expected = "May the force be with you";

        Assertions.assertEquals(expected, result);
    }
}
