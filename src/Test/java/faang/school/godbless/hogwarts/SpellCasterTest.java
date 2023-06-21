package faang.school.godbless.hogwarts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpellCasterTest {

    @Test
    void cast() {
        SpellCaster spellCaster = new SpellCaster();
        String alohomora = "Alohomora";
        Object actual = spellCaster.cast(alohomora, spell -> "The door is unlocked by " + spell);

        assertEquals("The door is unlocked by Alohomora" , actual);
    }
}