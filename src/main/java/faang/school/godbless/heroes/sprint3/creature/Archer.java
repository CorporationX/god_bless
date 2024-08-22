package faang.school.godbless.heroes.sprint3.creature;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Archer extends Creature {
    private String name = "archer";

    public Archer(int power) {
        super(power);
    }
}
