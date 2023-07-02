package faang.school.godbless.droid_secrets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDroidMessageEncryptor {

    private Droid droid;

    @BeforeEach
    void setUp() {
        droid = new Droid();
    }

    @Test
    void testSendEncryptedMessage() {
        Assertions.assertEquals("Ifmmp-!xpsme\"", droid.sendEncryptedMessage("Hello, world!", 1));
    }

    @Test
    void testReceiveEncryptedMessage() {
        Assertions.assertEquals("Hello, world!", droid.receiveEncryptedMessage("Ifmmp-!xpsme\"", 1));
    }


}
