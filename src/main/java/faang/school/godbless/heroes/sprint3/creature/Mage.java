package faang.school.godbless.heroes.sprint3.creature;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Mage extends Creature {
    private String name = "mage";

    public Mage(int power) {
        super(power);
    }
}
