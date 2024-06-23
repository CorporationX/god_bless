package faang.school.godbless.task2_1;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SpellCaster {
    public void cast(String name, SpellAction action) {
        System.out.println("name = " + name + ", action = " + action.act(name));
    }
}
