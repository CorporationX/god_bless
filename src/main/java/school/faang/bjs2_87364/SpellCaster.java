package school.faang.bjs2_87364;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        String result = action.castSpell(spellName);
        System.out.println("Spell result: " + result);
    }
}
