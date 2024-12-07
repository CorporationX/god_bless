package school.faang.task45439;

public class SpellCaster {

    public String cast(String cast, SpellAction action) {
        if (cast == null) {
            throw new IllegalArgumentException("cast is null");
        }
        return action.cast(cast);
    }
}
