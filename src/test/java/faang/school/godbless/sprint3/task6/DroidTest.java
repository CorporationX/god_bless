package faang.school.godbless.sprint3.task6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DroidTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testEncrypt(){
        Droid r2d2 = new Droid();
        Droid c3po = new Droid();
        String message = "May the Force be with you!";
        int encryptionKey = 3;
        String expected = message + "\r\n";

        r2d2.sendEncryptedMessage(c3po, message, encryptionKey);

        assertEquals(expected, outContent.toString());
    }

    @Test
    void testValidationNull() {
        Droid droid = new Droid();
        assertThrows(NullPointerException.class, () -> droid.sendEncryptedMessage(null, "kek", 1));
    }

    @Test
    void testValidationBlankMessage() {
        Droid droid = new Droid();
        assertThrows(NullPointerException.class, () -> droid.sendEncryptedMessage(new Droid(), " ", 1));
    }
}