package scool.faang.sprint.second.hogwarts;

import org.junit.Test;
import org.mockito.Mockito;
import school.faang.sprint.second.hogwarts.SpellAction;
import school.faang.sprint.second.hogwarts.SpellCaster;

public class TestSpellCaster {
    @Test
    public void testCast() {
        SpellCaster spellCaster = Mockito.spy(SpellCaster.class);
        SpellAction action = (s) -> "The door is unlocked by " + s;

        spellCaster.cast("Alohomora", action);
        Mockito.verify(spellCaster, Mockito.times(1)).cast("Alohomora", action);
    }
}
