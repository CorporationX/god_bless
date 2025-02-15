package school.faang.task_57462;

import lombok.NonNull;

public class SpellCaster {
    public void cast(@NonNull String spellTitle, @NonNull SpellAction spellAction) {
        System.out.println(spellAction.action(spellTitle));
    }
}
