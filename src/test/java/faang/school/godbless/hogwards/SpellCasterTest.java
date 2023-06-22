package faang.school.godbless.hogwards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpellCasterTest {

    private static final String ALOHOMORA = "Alohomora";
    private static final String ALOHOMORA_SPELL = "The door is unlocked by ";
    private static final String LUMOS = "Lumos";
    private static final String LUMOS_SPELL = "A beam of light is created by ";
    private static final String EXPELLIARMUS = "Expelliarmus";
    private static final String EXPELLIARMUS_SPELL = "The opponent is disarmed by ";

    private SpellCaster spellCaster;

    @BeforeEach
    void setup() {
        spellCaster = new SpellCaster();
    }

    @Test
    void alohomoraSpelltest() {
        String spellResult = spellCaster.cast(ALOHOMORA, (spell) -> ALOHOMORA_SPELL + spell);
        assertEquals(ALOHOMORA_SPELL + ALOHOMORA, spellResult);
    }

    @Test
    void lumosSpelltest() {
        String spellResult = spellCaster.cast(LUMOS, (spell) -> LUMOS_SPELL + spell);
        assertEquals(LUMOS_SPELL + LUMOS, spellResult);
    }

    @Test
    void expelliarmusSpelltest() {
        String spellResult = spellCaster.cast(EXPELLIARMUS, (spell) -> EXPELLIARMUS_SPELL+ spell);
        assertEquals(EXPELLIARMUS_SPELL + EXPELLIARMUS, spellResult);
    }
}

