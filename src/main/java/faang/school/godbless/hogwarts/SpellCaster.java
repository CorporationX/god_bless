package faang.school.godbless.hogwarts;

public class SpellCaster {
    void cast(String spellName, SpellAction action) {
        System.out.println(action.castSpell(spellName));
    }
}
