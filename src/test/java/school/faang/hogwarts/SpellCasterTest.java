package school.faang.hogwarts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpellCasterTest {
    private SpellCaster spellCaster;

    @BeforeEach
    public void setUp() {
        spellCaster = new SpellCaster();
    }

    @Test
    public void castSpellsTest() {
        spellCaster.cast("Alohomora", (spell) -> "The door is unlocked by " + spell);
        spellCaster.cast("Lumos", (spell) -> "A beam of light is created by " + spell);
        spellCaster.cast("Expelliarmus", (spell) -> "The opponent is disarmed by " + spell);
    }
}
