package faang.school.godbless;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SpellCasterTest {
    SpellCaster spellCaster;

    @BeforeEach
    public void setUp() {
        spellCaster = new SpellCaster();
    }

    @Test
    public void testSpellCasting() {
        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        String firstSpell = spellCaster.cast(alohomora, spell -> "The door is unlocked by " + spell);
        String secondSpell = spellCaster.cast(lumos, (spell) -> "A beam of light is created by " + spell);
        String thirdSpell = spellCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell);

        Assertions.assertEquals("The door is unlocked by Alohomora", firstSpell);
        Assertions.assertEquals("A beam of light is created by Lumos", secondSpell);
        Assertions.assertEquals("The opponent is disarmed by Expelliarmus", thirdSpell);
    }
}
