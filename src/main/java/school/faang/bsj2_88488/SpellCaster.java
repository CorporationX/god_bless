package school.faang.bsj2_88488;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        System.out.printf("%s, %s%n", spellName, spellAction.performSpell(spellName));
    }
}
