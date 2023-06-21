package faang.school.godbless.hogwards;

public class SpellCaster {

    public String cast(String spell, SpellAction spellAction) {
        return spellAction.act(spell);
    }
}
