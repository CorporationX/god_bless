package faang.school.godbless.hogwarts_hogwarts;

public class SpellCaster {

    public void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.act(spell));
    }
}