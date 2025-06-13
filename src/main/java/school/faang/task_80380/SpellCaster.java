package school.faang.task_80380;

public class SpellCaster {
    public void cast(String nameSpell, SpellAction spellAction) {
        System.out.println(spellAction.spell(nameSpell) + " by " + nameSpell);
    }
}
