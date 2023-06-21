package faang.school.godbless.Hogvards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpellCasterTest {
    SpellCaster spellCaster = new SpellCaster();
    @Test
    void testCastAlohomora() {
        String res = spellCaster.cast("Alohomora", thisSpell -> "The door is unlocked by " + thisSpell);
        assertEquals("The door is unlocked by Alohomora", res);
    }
}