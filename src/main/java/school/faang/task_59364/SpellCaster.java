package school.faang.task_59364;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        System.out.printf("Result: %s \n", action.castSpell(spellName));
    }
}
