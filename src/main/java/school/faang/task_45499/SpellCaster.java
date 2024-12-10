package school.faang.task_45499;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        var result = action.perform(spellName);
        System.out.println(result);
    }
}
