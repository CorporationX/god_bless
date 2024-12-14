package faang.school.godbless.heroes.multithreading.sprint.creature;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Archer extends Creature {
    private final String name = "archer";

    public Archer(int power) {
        super(power);
    }
}
