package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class Army {
    List<ArmyUnit> armyUnits = new ArrayList<>();
    int totalPower = 0;

    public int calculateTotalPower() {
        List<Thread> threads = new ArrayList<>();
        for (ArmyUnit armyUnit : armyUnits) {
            Thread thread = new Thread(() -> {
                totalPower += armyUnit.getPower();
            });
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return totalPower;
    }

    public void addUnit(ArmyUnit armyUnit) {
        armyUnits.add(armyUnit);
    }
}
