package school.faang.khogvarts;

import lombok.NonNull;

public class SpellCaster {
    public void cast(@NonNull String spell, @NonNull SpellAction action) {
        System.out.println(action.actionRun(spell));
    }
}
