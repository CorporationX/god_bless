package school.faang.task_48255;

import lombok.Getter;

public class PowerCalculatorThread extends  Thread {

    private final Unit unit;

    @Getter
    private int power;

    public PowerCalculatorThread(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        power = unit.getPower();
    }


}
