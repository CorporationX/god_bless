package school.faang.bjs2_80173;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpellCaster {

    public void cast(String nameSpell, SpellAction action) {
        String result = action.castSpell(nameSpell);
        log.info("Spell %s was cast: %s".formatted(nameSpell, result));
    }
}
