package faang.school.godbless.hogwarts;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SpellCaster {
    public void cast(String castName, SpellAction action) {
        System.out.println(action.action(castName));
    }
}
