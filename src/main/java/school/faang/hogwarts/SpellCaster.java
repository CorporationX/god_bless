package school.faang.hogwarts;

public class SpellCaster {
    public void cast(String spell, SpellAction action) {
        if (spell == null || action == null) {
            throw new IllegalArgumentException("Введи название");
        }
        String result = action.cast(spell);
        System.out.println(result);
    }
}
