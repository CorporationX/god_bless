package school.faang.task_45685;

public class SpellCaster {
    public void cast(String spell, SpellAction lambda) {
        System.out.println(lambda.spellAction(spell));
    }
}
