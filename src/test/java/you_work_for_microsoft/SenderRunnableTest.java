package you_work_for_microsoft;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SenderRunnableTest {

    @Test
    void run() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        SenderRunnable senderRunnable = new SenderRunnable(0, 1);
        senderRunnable.run();

        assertEquals("Письмо 0 отправлено\n", outContent.toString());

        System.setOut(originalOut);
    }
}