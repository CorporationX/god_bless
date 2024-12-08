package school.faang.task_45470;

public class SpellCaster {

    public void cast(String spellName, SpellAction actionSpell) {
        String res = actionSpell.action(spellName);
        System.out.println(res);
    }
}