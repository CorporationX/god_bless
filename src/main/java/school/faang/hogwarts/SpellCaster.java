package school.faang.hogwarts;

public class SpellCaster {

    public void cast(String spell, SpellAction spellAction) {
        String spellResult = spellAction.castSpell(spell);
        System.out.println(spellResult);
    }
}
