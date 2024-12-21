package school.faang.sprint_3.task_48027;

import lombok.Getter;

@Getter
public abstract class Unit {
    private final int power;

    public Unit(int power) {
        this.power = power;
    }
}
