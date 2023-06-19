package faang.school.godbless.droid_secrets;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DroidTest {

    @Test
    void testSendEncryptedMessage() {
        Droid droid1 = new Droid();
        Droid droid2 = new Droid();
        String encryptedMessage = droid1.sendEncryptedMessage(droid2, "Hello", 4);
        assertEquals("Lipps", encryptedMessage);
    }

    @Test
    void testReceiveEncryptedMessage() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        System.setOut(new PrintStream(outputStream));
        Droid droid1 = new Droid();
        Droid droid2 = new Droid();
        String encryptedMessage = droid1.sendEncryptedMessage(droid2, "Hello", 4);
        DroidMessageReceiver.receiveEncryptedMessage(encryptedMessage, 4);
        System.setOut(originalOut);
        String consoleOutput = outputStream.toString();

        assertTrue(consoleOutput.contains("Hello"));
    }
}