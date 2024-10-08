package SpellCaster;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        String result = action.castASpell(spellName);
        System.out.println(result);
    }
}
