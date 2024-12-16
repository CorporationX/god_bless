package school.faang.task_48006;

import lombok.Getter;

public class Unit {
    @Getter
    private final int power;
    private final String type;

    public Unit(int power, String type) {
        if (power <= 0) {
            throw new IllegalArgumentException("Power must be a positive integer");
        }
        this.power = power;

        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Type cannot be null");
        }
        this.type = type;
    }
}
