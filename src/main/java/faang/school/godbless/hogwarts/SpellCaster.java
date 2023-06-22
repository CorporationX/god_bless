package faang.school.godbless.hogwarts;

public class SpellCaster {

    public static String cast(String spell, SpellAction spellAction) {
        return spellAction.action(spell);
    }
}
