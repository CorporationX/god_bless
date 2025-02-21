package school.faang.task_61101;

import lombok.Getter;

@Getter
public abstract class Unit {
    private final int power;

    public Unit(int power) {
        validatePower(power);
        this.power = power;
    }

    private void validatePower(int power) {
        if (power < 0) {
            throw new IllegalArgumentException("Power can't be negative");
        }
    }
}
