package faang.school.godbless.BJS2_23377;

import lombok.Getter;

@Getter
public abstract class Unit {
    private int power;

    private static final int MINIMAL_POWER = 1;

    public Unit(int power) {
        if(power < MINIMAL_POWER) {
            throw new IllegalArgumentException("Pathetic");
        }

        this.power = power;
    }
}
