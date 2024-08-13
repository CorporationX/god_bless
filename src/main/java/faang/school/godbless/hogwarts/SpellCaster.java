package faang.school.godbless.hogwarts;

import java.lang.constant.Constable;
import java.security.Provider;
import java.util.function.Consumer;
import java.util.function.Function;

public class SpellCaster {

    public void cast(String spellTitle, SpellAction action) {
        System.out.println("Spell \"" + spellTitle + "\": " + action.cast(spellTitle));
    }
}
