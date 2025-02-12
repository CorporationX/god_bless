package school.faang.BJS2_57403;

import lombok.NonNull;

public class SpellCaster {
    public void cast(@NonNull String nameSpell, @NonNull SpellAction spellAction) {
        System.out.printf("%s\n", spellAction.castSpell(nameSpell));
    }
}
