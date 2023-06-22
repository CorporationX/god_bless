package faang.school.godbless.hogwarts;

public class SpellCaster {

    public String cast(String spellName, SpellAction spellAction) {
        return spellAction.run(spellName);
    }
}
