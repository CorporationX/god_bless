package faang.school.godbless.secondSprint.DroidSecrets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DroidTest {
    Droid balbes;
    Droid chel;

    @BeforeEach
    void setUp() {
        balbes = new Droid();
        chel = new Droid();
        balbes.sendEncryptedMessage(chel, "Help chel", 2);
        chel.sendEncryptedMessage(balbes, "No sorry", 5);
    }

    @Test
    public void testSendEncryptedMessageToBalbes() {
        String expected = "Jgnr ejgn";

        assertEquals(expected, chel.getMessage());
    }

    @Test
    public void testSendEncryptedMessageToChel() {
        String expected = "St xtwwd";

        assertEquals(expected, balbes.getMessage());
    }

    @Test
    public void testReceiveEncryptedMessageForChel() {
        String result = DroidMessageReceiver.receiveEncryptedMessage(chel.getMessage(), chel.getKey());
        String expected = "Help chel";

        assertEquals(expected, result);
    }

    @Test
    public void testReceiveEncryptedMessageForBalbes() {
        String result = DroidMessageReceiver.receiveEncryptedMessage(balbes.getMessage(), balbes.getKey());
        String expected = "No sorry";

        assertEquals(expected, result);
    }
}