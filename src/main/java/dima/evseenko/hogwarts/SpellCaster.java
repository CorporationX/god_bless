package dima.evseenko.hogwarts;

public class SpellCaster {
    public void cast(Spell spell, SpellAction action) {
        System.out.println(action.doAction(spell));
    }
}
