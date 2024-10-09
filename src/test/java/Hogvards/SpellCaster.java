package Hogvards;

public class SpellCaster {

    public void cast(String string, SpellAction spellAction) {
        System.out.println("Spell cast: " + spellAction.makeSpell(string));
    }
}

