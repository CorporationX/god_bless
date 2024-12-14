package school.faang.sprint_2.task_45655;

public class SpellCaster {
    public void cast(String spell, SpellAction action) {
        String result = action.perform(spell);
        System.out.println(result);
    }
}
