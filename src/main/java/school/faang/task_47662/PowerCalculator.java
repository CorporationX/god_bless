package school.faang.task_47662;

import lombok.Getter;
import school.faang.exception.CheckException;

@Getter
public class PowerCalculator implements Runnable {
    private final Unit unit;
    private int power;

    public PowerCalculator(Unit unit) {
        if (unit == null) {
            throw new CheckException("unit");
        }

        this.unit = unit;
    }

    @Override
    public void run() {
        this.power = unit.getPower();
    }
}
