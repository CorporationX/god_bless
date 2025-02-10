package school.faang.hogwarts_hogwarts_our_favourite_hogwarts.BJS2_57229;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpellCaster {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpellCaster.class);

    public void cast(String spellName, SpellAction spellAction) {
        if (spellName == null || spellName.isBlank()) {

            LOGGER.error("Spell name is null or empty");
            throw new IllegalArgumentException("Spell name is null or empty");
        }

        if (spellAction == null) {
            LOGGER.error("Spell action is null");
            throw new IllegalArgumentException("Spell action is null");
        }

        String result = spellAction.spell(spellName);
        System.out.println(result);

        LOGGER.info("Cast accomplished");
    }
}
