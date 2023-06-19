package hogwarts;

public class SpellCaster {
    public void cast(String spell, SpellAction action) {
        if (spell == null || spell.isBlank()) {
            throw new IllegalArgumentException("Was got empty string");
        }
        System.out.println(action.cast(spell));
    }
}
