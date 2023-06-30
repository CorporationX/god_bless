package faang.school.godbless.distributedArmy;

import lombok.Value;

@Value
public class Mage extends Unit {
    Mage(int power) {
        super("Mage", power);
    }
}
