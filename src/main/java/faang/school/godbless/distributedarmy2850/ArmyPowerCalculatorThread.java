package faang.school.godbless.distributedarmy2850;

import faang.school.godbless.distributedarmy2850.troop.Unit;
import lombok.Getter;

@Getter
public class ArmyPowerCalculatorThread extends Thread {
    private final Unit unit;
    private int power;

    public ArmyPowerCalculatorThread(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        power = unit.getPower();
    }
}
