package school.faang.hogwardshogwards;

import lombok.Data;


@Data

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        System.out.println(spellAction.doAction(spellName));
    }
}
