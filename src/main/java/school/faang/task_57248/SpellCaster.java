package school.faang.task_57248;

import java.util.Objects;

public class SpellCaster {
    public void cast(String str, SpellAction spellAction) {
        Objects.requireNonNull(spellAction, " Входящий параметр spellAction не может быть null");
        Objects.requireNonNull(str, "Входящий параметр str не может быть null");
        System.out.println(spellAction.action(str));
    }
}
