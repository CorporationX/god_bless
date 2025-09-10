package school.faang.hogwarts.hogwarts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpellCasterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private SpellCaster spellCaster;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        spellCaster = new SpellCaster();
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    private void assertCastOutput(String expected) {
        assertEquals(expected + System.lineSeparator(), outContent.toString());
        outContent.reset();
    }

    @Test
    void testCastAlohomora() {
        spellCaster.cast("Alohomora", spell -> "The door is unlocked by " + spell);

        assertCastOutput("Результат заклинания: The door is unlocked by Alohomora");

    }

    @Test
    void testCastLumos() {
        spellCaster.cast("Lumos", spell -> "A beam of light is created by " + spell);

        assertCastOutput("Результат заклинания: A beam of light is created by Lumos");
    }

    @Test
    void testCastExpelliarmus() {
        spellCaster.cast("Expelliarmus", spell -> "The opponent is disarmed by " + spell);

        assertCastOutput("Результат заклинания: The opponent is disarmed by Expelliarmus");
    }

    @Test
    void testSpellActionInterface() {
        SpellAction action = spell -> "Test action for " + spell;
        String result = action.castSpell("TestSpell");

        assertEquals("Test action for TestSpell", result);
    }

    @Test
    void testUppercaseAction() {
        spellCaster.cast("Wingardium", spell -> spell.toUpperCase(Locale.ROOT) + "!");

        assertCastOutput("Результат заклинания: WINGARDIUM!");
    }

    @Test
    void testReverseAction() {
        spellCaster.cast("Leviosa", spell -> new StringBuilder(spell).reverse().toString());

        assertCastOutput("Результат заклинания: asoiveL");
    }
}
