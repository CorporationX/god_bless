package school.faang.task_57451;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        String result = spellAction.cast(spellName);
        log.info("{}", result);
    }
}
