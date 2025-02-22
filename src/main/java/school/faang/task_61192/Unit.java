package school.faang.task_61192;

import lombok.Getter;

@Getter
public abstract class Unit {

    protected int power;

    public Unit(int power) {
        this.power = power;
    }
}
