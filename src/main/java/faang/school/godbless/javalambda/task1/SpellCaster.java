package faang.school.godbless.javalambda.task1;

public class SpellCaster {
    public String cast(String spell, SpellAction spellAction) {
        return spellAction.action(spell);
    }
}
