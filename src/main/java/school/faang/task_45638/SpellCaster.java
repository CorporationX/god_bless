package school.faang.task_45638;

public class SpellCaster {
    public void cast(String spell, SpellAction action) {
        if (spell.trim().isEmpty()) {
            throw new IllegalArgumentException("Spell cannot be empty");
        }
        if (action == null) {
            throw new IllegalArgumentException("Spell handler cannot be NULL");
        }
        String result = action.execute(spell);
        System.out.println(result);
    }
}
