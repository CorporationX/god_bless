package faang.school.godbless.hogwarts;

public class SpellCaster {

    void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.cast(spell));
    }
}
