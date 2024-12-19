package school.faang.sprint_3.task_47858;

import lombok.Getter;

@Getter
public abstract class Unit {
    protected int power;

    public Unit(int power) {
        this.power = power;
    }
}
