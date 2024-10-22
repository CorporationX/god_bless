package school.faang.bjs2_35904;

import lombok.Getter;

@Getter
public abstract class Unit {
    protected final int power;

    public Unit(int power) {
        this.power = power;
    }
}
