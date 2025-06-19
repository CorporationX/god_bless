package school.faang.bjs2_80351;

public class SpellCaster {
    public static void cast(String spellName, SpellAction action) {
        String result = action.perform(spellName);
        System.out.println(result);
    }
}
