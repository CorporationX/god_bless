package faang.school.godbless.sprint3.DroneSecrets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DroidTest {
@Test
    void testEncryptor(){
    Droid r2d2 = new Droid();
    Droid c3po = new Droid();
    String message = "May the Force be with you!";
    int encryptionKey = 3;

    String encryptedMsg = r2d2.sendEncryptedMessage(message, encryptionKey);
    String msg = c3po.receiveEncryptedMessage(encryptedMsg, encryptionKey);

    assertEquals(message,msg);
}
}