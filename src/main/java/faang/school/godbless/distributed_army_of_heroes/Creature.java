package faang.school.godbless.distributed_army_of_heroes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Creature {
    private int power;
    private Type type;
}
