package school.faang.hogwarts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpellCaster {

    private static final Logger logger = LoggerFactory.getLogger(SpellCaster.class);

    public void cast(String spellName, SpellAction action) {
        if (spellName == null || spellName.isBlank()) {
            IllegalArgumentException ex = new IllegalArgumentException("SpellName cannot be empty!");
            logger.error("SpellName cannot be empty!", ex);
            throw ex;
        }
        String result = action.spellCast(spellName);
        System.out.println(result);
    }
}
