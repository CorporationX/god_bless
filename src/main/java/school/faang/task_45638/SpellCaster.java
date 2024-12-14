package school.faang.task_45638;

public class SpellCaster {
    public void cast(String spell, SpellAction action) {
        String result = action.execute(spell);
        System.out.println(result);
    }
}
