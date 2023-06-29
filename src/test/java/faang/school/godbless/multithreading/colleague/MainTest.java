package faang.school.godbless.multithreading.colleague;

import faang.school.godbless.multithreading.colleague.Main;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
    private PrintStream console;
    private ByteArrayOutputStream output;

    @BeforeEach
    void setUp() {
        console = System.out;
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void tearDown() {
        System.setOut(console);
    }

    @Test
    void main() {
        Main.main(null);
        assertTrue(output.toString().contains("The names of all people have been printed"));
        assertEquals(output.toString().split("\n").length, 10001);
    }
}