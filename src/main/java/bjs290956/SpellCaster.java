package bjs290956;

public class SpellCaster {
    void cast(String spellName, SpellAction spellAction) {
        System.out.println(spellAction.castSpell(spellName));
    }
}
