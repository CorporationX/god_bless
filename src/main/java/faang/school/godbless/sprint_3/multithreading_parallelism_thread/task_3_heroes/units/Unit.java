package faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_3_heroes.units;

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
