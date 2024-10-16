package school.faang.sprint2.Hogvarts;

import java.util.function.Function;

public class SpellCaster {

    public void cast(String spell, SpellAction spellAction) {
        String str = spellAction.action(spell);
        System.out.println(str);
    }

}
