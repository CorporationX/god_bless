package faang.school.godbless.droid_secrets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DroidTest {
    @Test
    public void testDroids() {
        Droid r2d2 = new Droid();
        Droid c3po = new Droid();
        String message = "May the Force be with you!";
        int encryptionKey = 3;

        r2d2.sendEncryptedMessage(c3po, message, encryptionKey);
    }

}