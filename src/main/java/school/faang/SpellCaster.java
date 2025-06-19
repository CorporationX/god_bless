package school.faang;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        String result = action.castSpell(spellName);
        System.out.println("The result of the spell: " + result);
    }
}
