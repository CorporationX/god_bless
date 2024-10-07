package dima.evseenko.hogwarts;

import java.util.function.Function;

public class SpellCaster {
    public void cast(Spell spell, Function<Spell, String> action) {
        System.out.println(action.apply(spell));
    }
}
