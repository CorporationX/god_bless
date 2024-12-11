package school.faang.task_45581;

public class SpellCaster {
    public void cast(String spell, SpellAction spellAction) {
        String result = spellAction.execute(spell);
        System.out.println(result);
    }
}
