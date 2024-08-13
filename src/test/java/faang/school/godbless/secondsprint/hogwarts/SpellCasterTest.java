package faang.school.godbless.secondsprint.hogwarts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpellCasterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private SpellCaster wizard;

    @BeforeEach
    public void setUp() {
        wizard = new SpellCaster();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("Should print correct messages for different spells")
    public void testCast() {
        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        wizard.cast(alohomora, (spell) -> "The door is unlocked by " + spell);
        wizard.cast(lumos, (spell) -> "A beam of light is created by " + spell);
        wizard.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell);

        String expectedOutput = """
                The door is unlocked by Alohomora
                A beam of light is created by Lumos
                The opponent is disarmed by Expelliarmus
                """;

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    @DisplayName("Should handle null spell by printing a default message")
    public void testCastNullSpell() {
        String nihil = "";
        wizard.cast(nihil, (spell) -> "Casting " + spell);

        assertEquals("No spell has been cast\n", outContent.toString());
    }
}
