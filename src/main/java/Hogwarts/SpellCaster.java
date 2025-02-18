package Hogwarts;

public class SpellCaster implements  SpellActions {
    public void cast(String spellName, SpellAction spellAction) {
        if (spellName == null || spellName.isEmpty()) {
            throw new IllegalArgumentException("Вы не использовали заклинание" + spellName);
        }

        if (spellAction == null) {
            throw new IllegalArgumentException("Вы забыли про действие" + null);
        }
        System.out.println(spellAction.castSpellName(spellName));
    }
}
