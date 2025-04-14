package school.faang.bjs2_70190;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        System.out.println(spellAction.doSpell(spellName));
    }
}
