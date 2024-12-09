package school.faang.sprint_2.task_bjs245535;

public class SpellCaster {

    public void cast (String cast, SpellAction spellAction) {
        String explainedSpell = spellAction.explainSpell(cast);
        System.out.println(explainedSpell);
    }
}
