package school.faang.task_48171;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> units = new ArrayList<>();;
    final List<UnitThread> unitThreads;

    public Army() {
        unitThreads = new ArrayList<>();
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException {
        int totalPower = 0;
        for (Unit unit : units) {
            UnitThread unitThread = new UnitThread(unit);
            unitThreads.add(unitThread);
            unitThread.start();
        }

        for (UnitThread unitThread : unitThreads) {
            unitThread.join();
            totalPower += unitThread.getPower();
        }
        return totalPower;
    }
}
