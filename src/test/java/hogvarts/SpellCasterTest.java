package hogvarts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SpellCasterTest {
    private SpellCaster spellCaster;

    @BeforeEach
    public void setUp() {
        spellCaster = new SpellCaster();
    }

    @Test
    void cast() {
        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        String expectedAlohomoraResult = "The door is unlocked by Alohomora";
        String expectedLumosResult = "A beam of light is created by Lumos";
        String expectedExpelliarmusResult = "The opponent is disarmed by Expelliarmus";

        String actualAlohomoraResult = spellCaster.cast(alohomora,spellName -> "The door is unlocked by " + spellName);
        String actualLumosResult = spellCaster.cast(lumos, (spell) -> "A beam of light is created by " + spell);
        String actualExpelliarmusResult = spellCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell);

        assertEquals(expectedAlohomoraResult, actualAlohomoraResult);
        assertEquals(expectedLumosResult, actualLumosResult);
        assertEquals(expectedExpelliarmusResult, actualExpelliarmusResult);
    }
}