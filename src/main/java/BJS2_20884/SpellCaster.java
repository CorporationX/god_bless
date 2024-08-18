package BJS2_20884;

public class SpellCaster {
    public static String cast(String spellName, SpellAction spellAction){
        return spellAction.doSomeMagic(spellName);
    }
}
