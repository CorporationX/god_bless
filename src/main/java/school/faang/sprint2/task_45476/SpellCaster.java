package school.faang.sprint2.task_45476;

import lombok.NonNull;

public class SpellCaster {

    public void cast(@NonNull String spellName, @NonNull SpellAction spell) {
        System.out.println(spell.action(spellName));
    }
}
