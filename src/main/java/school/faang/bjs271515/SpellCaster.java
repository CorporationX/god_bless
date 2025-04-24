package school.faang.bjs271515;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        System.out.println(action.doSpell(spellName));
    }
}