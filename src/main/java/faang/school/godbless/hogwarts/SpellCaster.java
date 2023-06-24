package faang.school.godbless.hogwarts;

public class SpellCaster {

    public String cast(String spell, SpellAction spellAction) {
        return spellAction.castSpell(spell);
    }
}
