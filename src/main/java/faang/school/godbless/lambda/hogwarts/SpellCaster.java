package faang.school.godbless.lambda.hogwarts;

public class SpellCaster {
    public void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.performSpell(spell));
    }
}
