package faang.school.godbless.lambda.task1hogwarts;

public class SpellCaster {
    public void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.toSpellAction(spell));
    }
}
