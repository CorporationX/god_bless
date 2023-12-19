package faang.school.godbless.alexbulgakoff.functionalinterfaceslambdas.hogwarts;

import lombok.ToString;

/**
 * @author Alexander Bulgakov
 */

@ToString
public class SpellCaster {

    public void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.action(spell));
    }
}
