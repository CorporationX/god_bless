package school.faang.hogwarts;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpellCaster {
    public void cast(String name, SpellAction spellAction) {
        String result = spellAction.invoke(name);
        log.info(result);
    }
}
