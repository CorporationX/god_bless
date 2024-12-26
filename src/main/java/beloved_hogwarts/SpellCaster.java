package beloved_hogwarts;

public class SpellCaster {
    private static final SpellCaster spellCaster = new SpellCaster();

    public <T,R> void cast(T spell, java.util.function.Function<T,R> action) {
        R result = action.apply(spell);
        System.out.println("заклиание прменено: " + result);
    }
}

