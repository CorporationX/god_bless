package faang.school.godbless.secondsprint.hogwarts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpellCasterTest {
    private final OutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private SpellCaster wizard;

    @BeforeEach
    void setUp() {
        wizard = new SpellCaster();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("Should print correct messages for different spells")
    void testCast() {
        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        wizard.cast(alohomora, (spell) -> "The door is unlocked by " + spell);
        wizard.cast(lumos, (spell) -> "A beam of light is created by " + spell);
        wizard.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell);

        String expectedOutput = "The door is unlocked by Alohomora\n" +
                        "A beam of light is created by Lumos\n" +
                        "The opponent is disarmed by Expelliarmus\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    @DisplayName("Should handle null spell by printing a default message")
    void testCastNullSpell() {
        wizard.cast(null, (spell) -> spell == null ? "No spell has been cast" : "Casting " + spell);

        assertEquals("No spell has been cast\n", outContent.toString());
    }
}
