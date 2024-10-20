package school.faang.BJS2_35898;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException {
        int totalPower = 0;
        List<UnitThread> unitThreads = new ArrayList<>();
        for (Unit unit : units) {
            UnitThread thread = new UnitThread(unit);
            unitThreads.add(thread);
            thread.start();
        }
        for (UnitThread unitThread : unitThreads) {
            unitThread.join();
            totalPower += unitThread.getCountPower();
        }
        return totalPower;
    }
}
