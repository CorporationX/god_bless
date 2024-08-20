package faang.school.godbless.BJS2_23412;

import java.util.ArrayList;
import java.util.List;

public class Army {

    List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower(){
        List<UnitThread> unitThreads = new ArrayList<>();

        for (Unit unit : units) {
            UnitThread unitThread = new UnitThread(unit);
            unitThreads.add(unitThread);
            unitThread.start();
        }

        int totalPower = 0;
        for (UnitThread unitThread : unitThreads) {
            try {
                unitThread.join();
                totalPower += unitThread.getPower();
            }catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return totalPower;
    }
}
