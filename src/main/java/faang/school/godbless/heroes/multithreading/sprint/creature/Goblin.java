package faang.school.godbless.heroes.multithreading.sprint.creature;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Goblin extends Creature {
    private final String name = "goblin";

    public Goblin(int power) {
        super(power);
    }
}
