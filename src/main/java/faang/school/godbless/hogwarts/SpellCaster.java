package faang.school.godbless.hogwarts;

public class SpellCaster {
    public void cast(String spell, SpellAction action) {
        System.out.println(action.cast(spell));
    }
}
