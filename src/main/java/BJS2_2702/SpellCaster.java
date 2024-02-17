package BJS2_2702;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SpellCaster {
    SpellAction spellAction = (spell) -> "" + spell;

    void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.spellAction(spell));
    }
}

