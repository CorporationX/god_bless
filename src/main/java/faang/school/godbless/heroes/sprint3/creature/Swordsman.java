package faang.school.godbless.heroes.sprint3.creature;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Swordsman extends Creature {
    private String name = "swordsman";

    public Swordsman(int power) {
        super(power);
    }
}
