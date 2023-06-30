package faang.school.godbless.distributedArmy;

import lombok.Value;

@Value
public class Swordsman extends Unit {
    Swordsman(int power) {
        super("Swordsman", power);
    }
}
