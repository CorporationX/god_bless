package school.faang.sprint.third.army;

import lombok.Data;

@Data
public abstract class Warrior {
    private final int power;

    public Warrior(int power) {
        validatePower();
        this.power = power;
    }

    private void validatePower() {
        if (power < 0) {
            throw new IllegalArgumentException("Power cannot be negative");
        }
    }
}
