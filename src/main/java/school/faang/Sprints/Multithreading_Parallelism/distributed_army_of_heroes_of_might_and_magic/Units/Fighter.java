package school.faang.Sprints.Multithreading_Parallelism.distributed_army_of_heroes_of_might_and_magic.Units;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Fighter {
    private int power;

    public Fighter(int power) {
        this.power = power;
    }
}
