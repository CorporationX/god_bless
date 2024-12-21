package school.faang;

import java.util.function.Function;

public class SpellCaster {
    public void cast(String spell, Function<String, String> function) {
        System.out.println(function.apply(spell));
    }
}
