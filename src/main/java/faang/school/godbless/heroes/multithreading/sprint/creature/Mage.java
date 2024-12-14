package faang.school.godbless.heroes.multithreading.sprint.creature;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Mage extends Creature {
    private final String name = "mage";

    public Mage(int power) {
        super(power);
    }
}
