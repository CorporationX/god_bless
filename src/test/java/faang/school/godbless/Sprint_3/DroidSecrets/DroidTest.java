package faang.school.godbless.Sprint_3.DroidSecrets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DroidTest {
    Droid droid = new Droid();
    DroidMessageReceiver receiver = new DroidMessageReceiver();

    @Test
    public void sendEncryptedMessageTest() {
        String result = droid.sendEncryptedMessage("hello", 3);
        String expected = "khoor";
        assertEquals(expected, result);
    }

    @Test
    public void receiveEncryptedMessageTest() {
        String result = receiver.receiveEncryptedMessage("khoor", 3);
        String expected = "hello";
        assertEquals(expected, result);
    }
}