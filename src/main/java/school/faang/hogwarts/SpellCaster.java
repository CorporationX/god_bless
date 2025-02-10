package school.faang.hogwarts;

public class SpellCaster {
    void cast(String spell, SpellAction action) {
        if (spell == null || action == null) {
            return;
        }
        String result = action.cast(spell);
        System.out.println(result);
    }
}
