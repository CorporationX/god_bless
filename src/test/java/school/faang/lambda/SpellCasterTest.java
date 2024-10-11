package school.faang.lambda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpellCasterTest {

    @Test
    void cast() {
        SpellCaster spellCaster = new SpellCaster();
        String resultAction = spellCaster.cast("Close a window",phraseSA -> "The window is closed by a spell: " + phraseSA);
        assertEquals("The window is closed by a spell: Close a window", resultAction, "ErSpellCasterTest 001 - cast");
    }
}