package faang.school.godbless.hogwarts;

public class SpellCaster {
    public static String cast(String spellName, SpellAction spellAction) {
        return spellAction.action(spellName);
    }
}
