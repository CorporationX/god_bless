package school.faang.task_59364;

import java.util.Objects;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        Objects.requireNonNull(spellName, "spellName cannot be null");
        Objects.requireNonNull(action, "SpellAction cannot be null");
        System.out.printf("Result: %s \n", action.castSpell(spellName));
    }
}
