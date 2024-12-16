package school.faang.sprint_3.task_47707;

import lombok.Getter;

public class PowerCalculator implements Runnable {
    private final Unit unit;
    @Getter
    private int power;

    public PowerCalculator(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        this.power = unit.getPower();
    }
}
