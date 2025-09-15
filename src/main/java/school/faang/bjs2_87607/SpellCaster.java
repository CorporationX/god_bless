package school.faang.bjs2_87607;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpellCaster {

    public void cast(String spellName, SpellAction action) {
        String result = action.castSpell(spellName);
        log.info("Spell {} {}", spellName, result);
    }
}
