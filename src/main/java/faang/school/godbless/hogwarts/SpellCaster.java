package faang.school.godbless.hogwarts;

interface SpellAction {
    String action(String spellName);
}

public class SpellCaster {
    public static String cast(String spellName, SpellAction spellAction) {
        return spellAction.action(spellName);
    }
}
