package faang.school.godbless.lambda.hogwarts;

public class SpellCaster {
    public void cast(String spell, SpellAction action) {
        var spellResult = action.action(spell);
        System.out.println(spellResult);
    }
}
