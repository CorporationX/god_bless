package faang.school.godbless.sprint3.task7;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SpellCasterTest {
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
    void testCast() {
        String expected = "The door is unlocked by Alohomora\r\n";

        SpellCaster spellCaster = new SpellCaster();
        spellCaster.cast("Alohomora", (spell) -> "The door is unlocked by " + spell);

        assertEquals(expected, originalOut.toString());
    }
}