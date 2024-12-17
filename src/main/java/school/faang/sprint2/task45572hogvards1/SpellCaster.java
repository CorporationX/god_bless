package school.faang.sprint2.task45572hogvards1;

public class SpellCaster {
    void cast(String spell, SpellAction action) {
        if (spell == null || action == null) {
            throw new IllegalArgumentException("Неверные параметры");
        }
        System.out.println(action.act(spell));
    }
}