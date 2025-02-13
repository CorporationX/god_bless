package Hogwarts;

public class SpellCaster {
    @FunctionalInterface
    interface SpellAction {
        String castSpellName (String nameSpell);
    }

    public void cast (String spellName, SpellAction spellAction) {
        String result = spellAction.castSpellName(spellName);
        System.out.println(result);
    }
}
