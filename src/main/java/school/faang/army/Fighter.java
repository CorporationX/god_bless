package school.faang.army;

import lombok.Getter;

@Getter
public class Fighter {
    private final int power;

    public Fighter(int power) {
        validate(power);
        this.power = power;
    }

    private void validate(int power) {
        if (power < 0) {
            throw new IllegalArgumentException("Power can not be lower than 0");
        }
    }
}
