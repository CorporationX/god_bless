package faang.school.godbless.hogwarts;

public class SpellCaster {
    public String cast(String spellName, SpellAction action) {
        return action.act(spellName);
    }
}
