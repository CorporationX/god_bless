package school.faang;

import lombok.NonNull;

public class SpellCaster {
    public void cast(@NonNull String spell, SpellAction spellAction) {
        String result = spellAction.castSpell(spell);
        System.out.printf("Result of spell cast: %s\n", result);
    }
}
