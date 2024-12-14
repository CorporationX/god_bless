package faang.school.godbless.heroes.multithreading.sprint.creature;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Swordsman extends Creature {
    private final String name = "swordsman";

    public Swordsman(int power) {
        super(power);
    }
}
