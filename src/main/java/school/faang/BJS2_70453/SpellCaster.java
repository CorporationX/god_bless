package school.faang.BJS2_70453;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        String result = action.castSpell(spellName);
        System.out.println("The result of the spell " + spellName + ": " + result);
    }
}

