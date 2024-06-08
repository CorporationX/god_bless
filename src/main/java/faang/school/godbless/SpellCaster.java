package faang.school.godbless;

public class SpellCaster {
    public static String cast(String spellCast, SpellAction action){
        return action.accept(spellCast);
    }
}
