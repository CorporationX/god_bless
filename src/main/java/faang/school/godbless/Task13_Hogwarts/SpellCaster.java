package faang.school.godbless.Task13_Hogwarts;

import lombok.NoArgsConstructor;

@NoArgsConstructor

public class SpellCaster {
    public void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.cast(spell));
    }
}
