package hogwarts;

import javax.swing.*;

public class SpellCaster {
    public static void cast(String nameSpell, SpellAction spellAction) {

    }
}

@FunctionalInterface
interface SpellAction {
    public String Action(String spell);

}
