package faang.school.godbless.distributedArmy;

import lombok.Value;

@Value
public class Archer extends Unit {
    Archer(int power) {
        super("Archer", power);
    }
}
