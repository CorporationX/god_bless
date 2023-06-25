package faang.school.godbless.hogwarts;


public class SpellCaster {
    public <T> T cast(String spellName, SpellAction spellAction) {
        return (T) spellAction.action(spellName);
    }

}
