package school.faang.task_45645;

public class SpellCaster {
    public void cast(String spell, SpellAction action) {
        String result = action.cast(spell);
        System.out.println(result);
    }
}
