package faang.school.godbless.hogwards;

public class SpellCaster {
    void cast(String spell, SpellAction action) {
        System.out.println(spell + ": " + action.cast(spell));
    }
}
