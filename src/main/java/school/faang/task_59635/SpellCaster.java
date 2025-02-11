package school.faang.task_59635;

public class SpellCaster implements SpellAction {
    public void cast(String spellName, SpellAction spellAction) {
        System.out.printf("Spell result: %s\n", spellAction.castSpell(spellName));
    }

    @Override
    public String castSpell(String spellName) {
        return spellName;
    }
}
