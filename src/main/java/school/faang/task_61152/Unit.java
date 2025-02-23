package school.faang.task_61152;

import lombok.Getter;

@Getter
public abstract class Unit {
    private final int power;

    public Unit(int power) {
        this.power = power;
    }
}
