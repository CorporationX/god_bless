package school.faang.hogwarts_hogwarts_our_favourite_hogwarts.BJS2_57229;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpellCaster {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpellCaster.class);

    private static final String SPELL_NAME_NULL_OR_EMPTY = "Spell name is null or empty";
    private static final String SPELL_ACTION_NULL = "Spell action is null";

    public void cast(String spellName, SpellAction spellAction) {
        if (spellName == null || spellName.isBlank()) {

            LOGGER.error(SPELL_NAME_NULL_OR_EMPTY);
            throw new IllegalArgumentException(SPELL_NAME_NULL_OR_EMPTY);
        }

        if (spellAction == null) {
            LOGGER.error(SPELL_ACTION_NULL);
            throw new IllegalArgumentException(SPELL_ACTION_NULL);
        }

        String result = spellAction.spell(spellName);
        LOGGER.info(result);

        LOGGER.info("Cast accomplished");
    }
}
