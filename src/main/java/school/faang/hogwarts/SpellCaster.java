package school.faang.hogwarts;

public class SpellCaster {

    public void cast(String spellName, SpellAction spell) {
        System.out.println(spell.castSpell(spellName));
    }
}
