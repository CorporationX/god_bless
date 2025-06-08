package school.faang.bjs2_80161_spell_lambda;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class SpellCasterTest {

    @Test
    void shouldCastByCallingCallbackWithSpellName() {
        SpellCaster spellCaster = new SpellCaster();
        SpellAction mockAction = mock(SpellAction.class);
        String spellName = "Alohomora";
        spellCaster.cast(spellName, mockAction);
        verify(mockAction).generateDescription(spellName);
    }
}