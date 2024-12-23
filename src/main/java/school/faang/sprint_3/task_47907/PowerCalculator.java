package school.faang.sprint_3.task_47907;

import lombok.Getter;

public class PowerCalculator extends Thread {
    @Getter
    private int power;
    private final Unit unit;

    public PowerCalculator(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        this.power = unit.getPower();
    }
}
