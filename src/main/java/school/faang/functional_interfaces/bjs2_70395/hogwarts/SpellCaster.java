package school.faang.functional_interfaces.bjs2_70395.hogwarts;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        log.info(spellAction.doAction(spellName));
    }
}
