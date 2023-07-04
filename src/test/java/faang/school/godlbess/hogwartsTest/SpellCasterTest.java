package faang.school.godlbess.hogwartsTest;

import faang.school.godbless.SpellCaster;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SpellCasterTest {
    SpellCaster spellCaster;
    ByteArrayOutputStream outputStream;
    PrintStream printStream;

    @BeforeEach
    public void setUp() {
        spellCaster = new SpellCaster();
        outputStream = new ByteArrayOutputStream();
        printStream = new PrintStream(outputStream);

    }

    @Test
    public void testSpellCaster() {
        PrintStream originalPrintStream = System.out;
        System.setOut(printStream);

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, (spell) -> "The door is unlocked by " + spell);
        spellCaster.cast(lumos, (spell) -> "A beam of light is created by " + spell);
        spellCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell);

        System.setOut(originalPrintStream);
        String consoleOutput = outputStream.toString();

        assert consoleOutput.contains("The door is unlocked by Alohomora");
        assert consoleOutput.contains("A beam of light is created by Lumos");
        assert consoleOutput.contains("The opponent is disarmed by Expelliarmus");

    }


}