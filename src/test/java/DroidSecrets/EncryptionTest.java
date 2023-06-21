package DroidSecrets;

import faang.school.godbless.DroidSecrets.Droid;
import faang.school.godbless.DroidSecrets.DroidMessageReceiver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class EncryptionTest {
    Droid r2d2 = new Droid();
    Droid c3po = new Droid();
    String message = "May the Force be with you!";
    int encryptionKey = 3;
    @Test
    void encryptTest() {
        r2d2.sendEncryptedMessage(c3po, message, encryptionKey);

        assertNotEquals(message, c3po.getMessage());
    }

    @Test
    void decryptTest(){
        DroidMessageReceiver droidMessageReceiver = new DroidMessageReceiver();

        r2d2.sendEncryptedMessage(c3po, message, encryptionKey);
        String decrypted = droidMessageReceiver.receiveEncryptedMessage(c3po.getMessage(), 3);

        assertEquals(message,decrypted);
    }
}
