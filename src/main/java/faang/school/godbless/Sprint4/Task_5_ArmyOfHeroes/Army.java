package faang.school.godbless.Sprint4.Task_5_ArmyOfHeroes;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException {
        int allPower = 0;
        List<UnitThread> unitThreads = new ArrayList<>();

        for (Unit unit : units) {
            UnitThread unitThread = new UnitThread (unit);
            unitThread.start();
            unitThreads.add(unitThread);
        }

        for(UnitThread unitThread : unitThreads) {
            unitThread.join();
            allPower = allPower + unitThread.getUnitPower();
        }

        return allPower;
    }
}
