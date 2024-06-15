package faang.school.godbless.task_17_hogwarts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpellCasterTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private SpellCaster spellCaster;

    @BeforeEach
    void setUp() {
        this.spellCaster = new SpellCaster();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testCast(){
        // Arrange
        String spell = "spellName";
        String spellAction = "Some action by";
        String expectation = String.format("%s %s", spellAction, spell);

        // Action
        spellCaster.cast(spell, (s) -> String.format("%s %s", spellAction, s));

        // Assert
        assertEquals(expectation, outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
