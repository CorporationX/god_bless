package school.faang.bjs245613;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpellCaster {

    private static final Logger logger = LoggerFactory.getLogger(SpellCaster.class);

    public void cast(String spellName, SpellAction action) {
        if (spellName == null || spellName.trim().isEmpty()) {
            logger.warn("Attempted to call 'cast' method without 'spellName'");
            throw new IllegalArgumentException("Attempted to call 'cast' method without 'spellName'");
        }

        if (action == null) {
            logger.warn("Attempted to call 'cast' method without 'action'");
            throw new IllegalArgumentException("Attempted to call 'cast' method without 'action'");
        }
        try {
            String castResult = action.castSpell(spellName);
            logger.info("Spell '{}' successfully executed.", spellName);
            System.out.println(castResult);
        } catch (Exception e) {
            logger.error("Error executing spell '{}' ", spellName);

        }
    }
}
