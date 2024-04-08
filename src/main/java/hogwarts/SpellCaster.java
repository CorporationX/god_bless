package hogwarts;

import lombok.Data;

@Data
public class SpellCaster {
    public void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.action(spell));
    }
}
