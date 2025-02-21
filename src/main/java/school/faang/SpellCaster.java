package school.faang;

public class SpellCaster {

    public void cast(String spellName, SpellAction readSpell) {
        System.out.println(readSpell.doMagic(spellName));
    }
}
