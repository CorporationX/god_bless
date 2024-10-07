package hogwarts_hogwarts_our_beloved_hogwarts;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpellCasterTest {
    @Test
    void cast() {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        spellCaster.cast(alohomora, (spell) -> "The door is unlocked by " + spell);
        spellCaster.cast(lumos, (spell) -> "A beam of light is created by " + spell);
        spellCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell);

        assertEquals(
                "The door is unlocked by Alohomora\n" +
                        "A beam of light is created by Lumos\n" +
                        "The opponent is disarmed by Expelliarmus\n",
                outContent.toString()
        );

        System.setOut(originalOut);
    }
}