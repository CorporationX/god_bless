package hogwarts;

public class SpellCaster {
    public String cast(String nameSpell, SpellAction spellAction) {
        return spellAction.spell(nameSpell);
    }
}


