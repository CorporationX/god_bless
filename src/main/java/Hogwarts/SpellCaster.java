package Hogwarts;

@FunctionalInterface
interface SpellAction {
    String castSpellName (String nameSpell);
}

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        if (spellName == null) {
            throw new IllegalArgumentException("Вы не использовали заклинание");
        }

        if (spellAction == null) {
            throw new IllegalArgumentException("Вы забыли про действие");
        }
        String result = spellAction.castSpellName(spellName);
        System.out.println(result);
    }
}
