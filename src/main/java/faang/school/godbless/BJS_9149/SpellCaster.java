package faang.school.godbless.BJS_9149;

public class SpellCaster {
    public static String cast(String spellCast, SpellAction action){
        return action.accept(spellCast);
    }
}
