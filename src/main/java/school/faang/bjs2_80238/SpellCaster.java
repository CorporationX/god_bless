package school.faang.bjs2_80238;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        log.info(spellAction.performCast(spellName));
    }
}
