package spell;

/**
 * Performs an action based on the given spell name.
 * This method takes a spell name and returns a string that describes
 * the result of the spell action.
 *
 * @param sellName the name of the spell to be cast.
 * @return a string describing the result of the spell action.
 */

@FunctionalInterface
public interface SpellAction {
    String castSpell(String spellName);
}
