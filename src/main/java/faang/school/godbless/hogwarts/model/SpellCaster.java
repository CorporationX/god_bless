package faang.school.godbless.hogwarts.model;

import faang.school.godbless.hogwarts.interfaces.SpellAction;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        System.out.println(spellAction.act(spellName));
    }
}
