public class SpellCaster {
    public static String cast(String spell, SpellAction spellName){
        return spellName.spellSay(spell);
    }
}
