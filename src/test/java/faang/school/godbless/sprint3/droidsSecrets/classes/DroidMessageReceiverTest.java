package faang.school.godbless.sprint3.droidsSecrets.classes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DroidMessageReceiverTest {
    private final static int ENCRYPT_KEY = 1;
    private final static String MESSAGE = "Hello, world!";

    private static Droid D1;
    private static Droid D2;
    private static DroidMessageReceiver receiver;

    @BeforeAll
    static void setUp() {
        D1 = new Droid();
        D2 = new Droid();
        receiver = new DroidMessageReceiver();
    }

    @Test
    @DisplayName("receiveEncryptedMessage and sendEncryptedMessage test")
    void receiveEncryptedMessage_test() {
        D1.sendEncryptedMessage(D2, MESSAGE, ENCRYPT_KEY);
        assertNotEquals(MESSAGE, D2.getEncryptedMessage());
        String decryptedMessage = receiver.receiveEncryptedMessage(D2.getEncryptedMessage(), ENCRYPT_KEY);
        assertEquals(MESSAGE, decryptedMessage);
    }
}