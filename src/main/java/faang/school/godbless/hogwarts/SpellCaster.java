package faang.school.godbless.hogwarts;

import faang.school.godbless.hogwarts.interfaceSpellAction.SpellAction;

public class SpellCaster {

    public String cast(String spellName, SpellAction spell) {
        return spell.getSpell(spellName);
    }
}
