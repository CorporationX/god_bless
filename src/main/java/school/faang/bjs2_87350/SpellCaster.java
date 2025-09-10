package school.faang.bjs2_87350;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        String result = action.getSpell(spellName);
        System.out.println(result);
    }
}
