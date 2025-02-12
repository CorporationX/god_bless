package school.faang.BJS2_57340;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpellCaster {
    @NonNull
    public void cast(String spellName, SpellAction action) {
        String result = action.castSpell(spellName);
        log.info(result);
    }
}
