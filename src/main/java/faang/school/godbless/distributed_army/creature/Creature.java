package faang.school.godbless.distributed_army.creature;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Creature {
    private String name;
    private int power;
}
