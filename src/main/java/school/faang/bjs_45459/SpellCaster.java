package school.faang.bjs_45459;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpellCaster {
    public String cast(String spell, SpellAction action) {
        String result = action.spell(spell);
        log.info(result);
        return result;
    }
}
