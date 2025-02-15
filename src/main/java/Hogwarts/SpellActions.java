package Hogwarts;

public interface SpellActions {
    @FunctionalInterface
    interface SpellAction {
        String castSpellName (String nameSpell);
    }
}
