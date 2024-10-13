package school.faang.distributedarmy;

import lombok.Data;

@Data
public abstract class Unit {
    private final int power;

    protected Unit(int power) {
        this.power = power;
    }
}
