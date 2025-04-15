package school.faang.sprint_2.hogwards_hogwards;

public class SpellCaster {
    public static void cast(String spellName, SpellAction action) {
        String result = action.castSpell(spellName);
        System.out.println(result);
    }
}
