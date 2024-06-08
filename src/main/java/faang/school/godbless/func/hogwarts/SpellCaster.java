package faang.school.godbless.func.hogwarts;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class SpellCaster {

    public void cast(String spellName, SpellAction spellAction) {
        System.out.println(spellAction.cast(spellName));
    }
}
