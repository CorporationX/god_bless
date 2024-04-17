package faang.school.godbless.parallelism.heroesOfMightAndMagic;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Army {
    private final List<ArmyUnit> allArmyUnitsList = new ArrayList<>();

    public int calculateTotalPower() {
        allArmyUnitsList.forEach(unit -> {
            var powerCalculationThread = new PowerCalculationThread(unit);

            powerCalculationThread.start();
            try {
                powerCalculationThread.join();
            } catch (InterruptedException e) {
                log.error("During the total power of army calculation was thrown exception.", e);
            }
        });

        return PowerCalculationThread.getTotalPower();
    }

    public void addUnit(ArmyUnit unit) {
        if (unit == null) {
            return;
        }

        allArmyUnitsList.add(unit);
    }
}
