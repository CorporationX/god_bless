package school.faang.bjs48074;

import lombok.Getter;

public class PowerCalculator extends Thread {
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
