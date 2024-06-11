package faang.school.godbless.lambdaEx;

import lombok.Data;

@Data
public class SpellCaster {

    public void cast(String spellName, SpellAction spellAction) {
        System.out.println(spellName + " - " + spellAction.executeSpell(spellName));
    }
}
