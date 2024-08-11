package faang.school.godbless.hogwarts_hogwarts_our_beloved_hogwarts;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SpellCasterTest {
    @Test
    void testCast() {
        SpellCaster spellCaster = new SpellCaster();
        SpellAction action = mock(SpellAction.class);
        when(action.cast(Mockito.<String>any())).thenReturn("Cast");
        spellCaster.cast("Spell", action);
        verify(action).cast(eq("Spell"));
    }
}
