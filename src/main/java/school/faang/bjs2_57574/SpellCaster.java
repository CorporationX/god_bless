package school.faang.bjs2_57574;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpellCaster {
    public void cast(@NonNull String spellName, @NonNull SpellAction spellAction) {
        log.info(spellAction.castSpell(spellName));
    }
}
