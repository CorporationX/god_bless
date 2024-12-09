package school.faang.hogwarts_hogwarts;

public class SpellCaster {
    void cast(String spellName, SpellAction spellAction) {
        System.out.println(spellAction.act(spellName));
    }
}
