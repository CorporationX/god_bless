package faang.school.godbless.Army;

import lombok.Getter;

@Getter
public class PowerCalculator extends Thread {
    private Unit unit;
    private int power;

    public PowerCalculator(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        this.power = unit.getPower();
    }
}
