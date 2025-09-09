package Magi87317;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction){
        String castFull = spellAction.cast(spellName);
        System.out.println(castFull);
    }

}
