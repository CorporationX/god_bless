package faang.school.godbless.task_3_heroes.units;

import lombok.Getter;

@Getter
public class Unit {
    protected int power;

    public Unit(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}
