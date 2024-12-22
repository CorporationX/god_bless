package school.faang.task_48162;

import lombok.Getter;

public class PowerCalculation implements Runnable {
    private final Unit unit;
    @Getter
    private int power;

    public PowerCalculation(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        power = unit.getPower();
    }
}
