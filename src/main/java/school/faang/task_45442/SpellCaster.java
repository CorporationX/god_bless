package school.faang.task_45442;

import lombok.extern.slf4j.Slf4j;
import school.faang.task_45442.model.Spell;

@Slf4j
public class SpellCaster {
    public void cast(Spell spell, SpellAction spellAction) {
        String spellResult = spellAction.doSpell(spell);
        log.info("Result of {}: {}", spell, spellResult);
    }
}
