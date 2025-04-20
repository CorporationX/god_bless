package school.faang.heroes;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = false)
@ToString
public class Mage extends Warrior {

    Mage(int power) {
        super(power);
    }
}
