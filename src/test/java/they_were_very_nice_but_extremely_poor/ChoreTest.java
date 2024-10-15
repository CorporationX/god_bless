package they_were_very_nice_but_extremely_poor;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ChoreTest {
    @Test
    void run() {
        Chore chore = new Chore("Wash dishes");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        chore.run();

        assertEquals(
                """
                        Test worker is running: Wash dishes
                        Test worker is done: Wash dishes
                        """,
                outContent.toString()
        );

        System.setOut(originalOut);
    }
}