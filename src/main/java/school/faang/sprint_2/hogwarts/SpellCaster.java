package school.faang.sprint_2.hogwarts;

public class SpellCaster {

    void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.action(spell));
    }
}
