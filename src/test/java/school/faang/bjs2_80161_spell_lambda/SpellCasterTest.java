package school.faang.bjs2_80161_spell_lambda;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class SpellCasterTest {

    @Test
    void shouldCastByCallingCallbackWithSpell() {
        SpellCaster spellCaster = new SpellCaster();
        SpellAction mockAction = mock(SpellAction.class);
        String spell = "Alohomora";
        spellCaster.cast(spell, mockAction);
        verify(mockAction).generateDescription(spell);
    }
}