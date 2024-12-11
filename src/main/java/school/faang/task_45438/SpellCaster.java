package school.faang.task_45438;

public class SpellCaster {
    public void cast(Spell spell, SpellAction action) {
        try {
            String result = action.cast(spell);
            System.out.println(result);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
