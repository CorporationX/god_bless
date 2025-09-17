package school.faang.bjs2_87504;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        System.out.println("The result of the spell: " + action.castSpell(spellName));
    }
}
