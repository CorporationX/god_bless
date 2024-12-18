package school.faang.distributedarmy;

import lombok.Getter;

@Getter
public abstract class Unit {
    protected int power;

    public Unit(int power) {
        this.power = power;
    }
}
