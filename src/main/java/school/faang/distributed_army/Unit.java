package school.faang.distributed_army;

import lombok.Getter;

@Getter
public abstract class Unit {
    private final int power;

    public Unit(int power) {
        this.power = power;
    }
}