package school.faang.heroes;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = false)
@ToString
public class Archer extends Warrior {

    Archer(int power) {
        super(power);
    }
}
