package school.faangSprint3.t02;

import lombok.Data;

@Data
public class PowerCalculator implements Runnable {
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