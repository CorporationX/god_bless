package school.faang.sprint1.task_45596;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        String result = action.perform(spellName);
        System.out.println(result);
    }
}
