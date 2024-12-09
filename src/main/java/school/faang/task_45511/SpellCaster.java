package school.faang.task_45511;

public class SpellCaster {

    public void cast(String spellName, SpellAction action) {
        var executedSpell = action.castSpell(spellName);
        System.out.println(executedSpell);
    }
}
