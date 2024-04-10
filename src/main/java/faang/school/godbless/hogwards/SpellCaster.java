package faang.school.godbless.hogwards;

import faang.school.godbless.hogwards.SpellAction;

public class SpellCaster {
    void cast(String nameOfSpell, SpellAction spellAction) {
        System.out.println(spellAction.action(nameOfSpell));
    }
}