package faang.school.godbless.hogwarts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpellCasterTest {

    @Test
    void testCast() {
        String spellAlohomora = "Alohomora";
        String spellLumos = "Lumos";
        String spellExpelliarmus = "Expelliarmus";

        String firstSpell = SpellCaster.cast(spellAlohomora, spell -> "The door is unlocked by " + spell);
        String secondSpell = SpellCaster.cast(spellLumos, (spell) -> "A beam of light is created by " + spell);
        String thirdSpell = SpellCaster.cast(spellExpelliarmus, (spell) -> "The opponent is disarmed by " + spell);

        assertEquals("The door is unlocked by Alohomora", firstSpell);
        assertEquals("A beam of light is created by Lumos", secondSpell);
        assertEquals("The opponent is disarmed by Expelliarmus", thirdSpell);

    }
}