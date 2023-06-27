package faang.school.godbless.sprint3.hogwarts;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SpellCaster {
    public String cast(String spellName, SpellAction spellAction) {
        return spellAction.act(spellName);
    }
}
