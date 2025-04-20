package school.faang.heroes;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = false)
@ToString
public class Swordsman extends Warrior {
    Swordsman(int power) {
        super(power);
    }
}
