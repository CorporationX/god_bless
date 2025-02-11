package school.faang.task_59635;

/**
 * Interface for defining spell actions.
 * Provides a way to perform magic spells with a given name.
 *
 *  @author [Vladislav Zhurbin]
 */
@FunctionalInterface
public interface SpellAction {
    /**
     * Performs a spell with the specified name.
     *
     * @param spellName name of the spell to be executed
     * @return result of spell execution
     * @throws IllegalArgumentException if spellName is null
     */
    String castSpell(String spellName);
}
