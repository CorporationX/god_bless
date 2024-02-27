package lymbda.task1;

public class SpellCaster {
    public String cast(String spell, SpellAction spellAction){
        return spellAction.cast(spell);
    }

}
