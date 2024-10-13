package school.faang.bjs2_33881;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpellCasterTest {

    @Test
    void cast() {
        SpellCaster spellCaster = new SpellCaster();
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> spellCaster.cast(null, spellName -> "test"));
        IllegalArgumentException illegalArgumentException2 = assertThrows(IllegalArgumentException.class,
                () -> spellCaster.cast("Test", null));

        assertEquals(ErrorMassagesValidate.SPELL_NAME_IS_NULL.name(), illegalArgumentException.getMessage());
        assertEquals(ErrorMassagesValidate.SPELL_ACTION_IS_NULL.name(), illegalArgumentException2.getMessage());
    }
}