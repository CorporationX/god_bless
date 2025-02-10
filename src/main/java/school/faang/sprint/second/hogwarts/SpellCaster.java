package school.faang.sprint.second.hogwarts;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpellCaster {
    public void cast(@NonNull String spellName, SpellAction spellAction) {
        log.info(spellAction.castSpell(spellName));
    }
}
