package school.faang.BJS2_35890;

import lombok.Getter;
import school.faang.BJS2_35890.entity.Unit;

public class PowerCalculator extends Thread {

    private final Unit unit;

    @Getter
    private int result;

    public PowerCalculator(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        result = unit.getPower();
    }
}
