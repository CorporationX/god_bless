package school.faang.hogwarts.hogwarts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpellCaster {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public void cast(String spell, SpellAction spellAction) {
        checkValidSpell(spell);
        checkValidSpellAction(spellAction);
        logger.info(spellAction.castSpell(spell));
    }

    private void checkValidSpell(String spell) {
        if (spell == null || spell.isBlank()) {
            throw new IllegalArgumentException("The spell cannot be empty.");
        }
    }

    private void checkValidSpellAction(SpellAction spellAction) {
        if (spellAction == null) {
            throw new IllegalArgumentException("The spell action cannot be null.");
        }
    }
}
