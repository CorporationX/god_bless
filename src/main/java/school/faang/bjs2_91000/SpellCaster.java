package school.faang.bjs2_91000;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        System.out.println(spellAction.castSpell(spellName));
    }
}