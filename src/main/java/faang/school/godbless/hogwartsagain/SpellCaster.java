package faang.school.godbless.hogwartsagain;

public class SpellCaster {
    public String cast(String spell, SpellAction spellAction) {
        return spellAction.spellCast(spell);
    }
}
