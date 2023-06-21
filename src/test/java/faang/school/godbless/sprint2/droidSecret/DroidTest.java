package faang.school.godbless.sprint2.droidSecret;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DroidTest {
    @Test
    public void sendEncryptedMessageTest() {
        Droid droid = new Droid();
        Droid droid1 = new Droid();
        String result = droid.sendEncryptedMessage(droid1, "hello", 3);
        String expected = "khoor";
        assertEquals(expected, result);
    }
}