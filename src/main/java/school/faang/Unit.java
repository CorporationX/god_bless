package school.faang;

import lombok.Getter;

@Getter
public abstract class Unit {
    private int power;

    public int getPower() {
        return power;
    }

    public Unit(int power) {
        this.power = power;
    }
}

