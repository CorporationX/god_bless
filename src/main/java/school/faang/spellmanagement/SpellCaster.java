package school.faang.spellmanagement;

public class SpellCaster {

    public void cast(String spellName, SpellAction action) {
        String result = action.castSpell(spellName);
        System.out.println(result);
    }
}
