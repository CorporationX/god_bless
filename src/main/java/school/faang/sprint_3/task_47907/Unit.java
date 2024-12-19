package school.faang.sprint_3.task_47907;

import lombok.Getter;


@Getter
public abstract class Unit {
    private final int power;

    public Unit(int power) {
        this.power = power;
    }
}
