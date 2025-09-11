package school.faang.bjs2_87403;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        String castSpell = spellAction.castSpell(spellName);
        System.out.print(castSpell);
    }
}