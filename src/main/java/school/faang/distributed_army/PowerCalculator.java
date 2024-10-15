package school.faang.distributed_army;

import lombok.Getter;

public class PowerCalculator implements Runnable {
    private final Unit UNIT;
    @Getter
    private int power;

    public PowerCalculator(Unit UNIT) {
        this.UNIT = UNIT;
    }

    @Override
    public void run() {
        this.power = UNIT.getPower();
    }
}