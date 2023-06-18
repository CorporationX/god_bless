package hogvarts;

public class SpellCaster {
    public String cast(String spellName, SpellAction spellAction) {
        return spellAction.performSpell(spellName);
    }
}
