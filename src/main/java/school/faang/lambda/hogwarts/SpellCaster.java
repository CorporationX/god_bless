package school.faang.lambda.hogwarts;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        log.info("{}", action.printSpell(spellName));
    }
}
