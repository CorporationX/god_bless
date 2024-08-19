package multithreading.homm;

import lombok.Getter;
import multithreading.homm.units.Unit;

@Getter
public class UnitPowerCalculator extends Thread {
    private int power;
    private final Unit unit;

    public UnitPowerCalculator(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        power = unit.getPower();
    }
}
