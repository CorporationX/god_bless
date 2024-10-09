package dima.evseenko.hogwarts;

@FunctionalInterface
public interface SpellAction {
    String doAction(Spell spell);
}
