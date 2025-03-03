package school.faang;

import lombok.Getter;

@Getter
public class Unit {
    private final int power;

    public Unit(int power) {
        validatePower(power);
        this.power = power;
    }

    public void validatePower(int power) {
        if (power < 0) {
            throw new IllegalArgumentException("Сила не может быть меньше 0: " + power);
        }
    }
}
