package faang.school.godbless.HogwartsHogwarts;

public class SpellCaster {
    public static String cast(String spellName, SpellAction spellAction)
    {
        return spellAction.castResult(spellName);
    }
}
