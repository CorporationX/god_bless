package faang.school.godbless.droid_secrets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DroidTest {

    @Test
    void testSendEncryptedMessage() {
        String actualOutput = new Droid().sendEncryptedMessage(new Droid(), "Hello", 1);
        String expectedOutput = "Ifmmp";

        assertEquals(expectedOutput, actualOutput);
    }
}
