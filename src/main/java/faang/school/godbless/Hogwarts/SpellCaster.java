package faang.school.godbless.Hogwarts;

import faang.school.godbless.Hogwarts.SpellAction;

public class SpellCaster {

    public void cast(String spell, SpellAction action) {
        String result = action.castSpell(spell);
        System.out.println(result);
    }
}
