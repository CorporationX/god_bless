package school.faang.task_59635;

public class SpellCaster implements SpellAction {
    private static final String SPELL_NAME_NULL_ERROR = "spellName must not be null";
    private static final String SPELL_ACTION_NULL_ERROR = "spellAction must not be null";

    public void cast(String spellName, SpellAction spellAction) {
        if (spellName == null) {
            throw new IllegalArgumentException(SPELL_NAME_NULL_ERROR);
        }
        if (spellAction == null) {
            throw new IllegalArgumentException(SPELL_ACTION_NULL_ERROR);
        }
        System.out.printf("Spell result: %s\n", spellAction.castSpell(spellName));
    }

    @Override
    public String castSpell(String spellName) {
        if (spellName == null) {
            throw new IllegalArgumentException(SPELL_NAME_NULL_ERROR);
        }
        return spellName;
    }
}
