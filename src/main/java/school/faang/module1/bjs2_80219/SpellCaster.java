package school.faang.module1.bjs2_80219;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        log.info(spellAction.cast(spellName));
    }
}