package school.faang.task57532.spell;

import lombok.NonNull;

public class SpellCaster {
    public void cast(@NonNull String spellName, @NonNull SpellAction spellAction) {
        System.out.println(spellAction.spell(spellName));
    }
}
