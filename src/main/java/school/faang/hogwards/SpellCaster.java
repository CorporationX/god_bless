package school.faang.hogwards;

import java.util.function.Consumer;

public class SpellCaster {

    public void cast(String spellName, SpellAction action) {
        String result = action.execute(spellName);
        System.out.println(result);
    }
}
