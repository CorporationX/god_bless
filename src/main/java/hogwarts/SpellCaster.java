package hogwarts;

import lombok.NonNull;

public class SpellCaster {
    public void cast(@NonNull String spellName, @NonNull SpellAction spellAction) {
        System.out.println(spellAction.getAction(spellName));
    }
}
