package BJS2_57383;

import lombok.NonNull;

public class SpellCaster {
    public void cast(@NonNull String spell, @NonNull SpellAction action) {
        System.out.println(action.cast(spell));
    }
}
