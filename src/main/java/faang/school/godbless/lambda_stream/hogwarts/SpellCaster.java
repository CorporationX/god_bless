package faang.school.godbless.lambda_stream.hogwarts;

public class SpellCaster {
    public static String cast(String spellName, SpellAction spellAction) {
        return spellAction.action(spellName);
    }
}
