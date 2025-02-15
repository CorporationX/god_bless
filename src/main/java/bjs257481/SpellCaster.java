package bjs257481;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpellCaster {
    private static final Logger logger = LoggerFactory.getLogger(SpellCaster.class);

    public void cast(String spellName, SpellAction spellAction) {
        logger.info("Spell action: {}", spellAction.cast(spellName));
    }
}
