package faang.school.godbless.hogwarts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SpellCasterTest {

    private SpellCaster spellCaster;

    @BeforeEach
    public void setUp() {
        spellCaster = new SpellCaster();
    }

    @Test
    public void testSpellCaster() {
        String spellAlohomora = "The door is unlocked by Alohomora";
        String spellLumos = "A beam of light is created by Lumos";
        String spellExpilliarmus = "The opponent is disarmed by Expelliarmus";
        String alohomora = spellCaster.cast("Alohomora", (spell) -> "The door is unlocked by " + spell);
        String lumos = spellCaster.cast("Lumos", (spell) -> "A beam of light is created by " + spell);
        String expelliarmus = spellCaster.cast("Expelliarmus", (spell) -> "The opponent is disarmed by " + spell);
        Assertions.assertEquals(spellAlohomora, alohomora);
        Assertions.assertEquals(spellLumos, lumos);
        Assertions.assertEquals(spellExpilliarmus, expelliarmus);
    }
}
