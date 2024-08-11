package faang.school.godbless.task.lambda.hogwarts.hogwarts;

public class SpellCaster {

    public void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.act(spell));
    }
}
