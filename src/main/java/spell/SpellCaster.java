package spell;

import java.util.Objects;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        Objects.requireNonNull(spellName, "Spell name cannot be null.");
        Objects.requireNonNull(spellAction, "Spell action cannot be null.");
        System.out.println(spellAction.castSpell(spellName));
    }
}
