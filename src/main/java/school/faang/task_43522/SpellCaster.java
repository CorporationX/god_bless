package school.faang.task_43522;

public class SpellCaster {
    public void cast(Spell spell, SpellAction action) {
        String result = action.cast(spell);
        System.out.println(result);
    }
}
