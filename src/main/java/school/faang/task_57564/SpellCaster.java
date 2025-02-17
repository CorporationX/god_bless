package school.faang.task_57564;

import lombok.NonNull;

public class SpellCaster {
    public void cast(@NonNull String spellName, @NonNull SpellAction action) {
        System.out.println(action.castSpell(spellName));
    }
}
