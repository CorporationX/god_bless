package school.faang.bjs2_37814;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SenderRunnableTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {

        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testSenderRunnable() throws InterruptedException {

        int startIndex = 0;
        int endIndex = 4;
        SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);


        Thread thread = new Thread(senderRunnable);
        thread.start();
        thread.join();


        for (int i = startIndex; i <= endIndex; i++) {
            assertTrue(outContent.toString().contains("Email " + i + " Send "));
        }
    }
}
