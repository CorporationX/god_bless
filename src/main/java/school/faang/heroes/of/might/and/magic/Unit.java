package school.faang.heroes.of.might.and.magic;

import lombok.Getter;

@Getter
public abstract class Unit {
    protected final int power;

    public Unit(int power) {
        this.power = power;
    }
}