package faang.school.godbless.heroes.sprint3.creature;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Goblin extends Creature {
    private String name = "goblin";

    public Goblin(int power) {
        super(power);
    }
}
