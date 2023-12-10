package faang.school.godbless.lambda.task1hogwarts;

import java.util.function.Function;

public class SpellCaster {
    public void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.toSpellAction(spell));
    }
}
