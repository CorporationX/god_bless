package faang.school.godbless.BJS2_3157;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException {
        int totalPower = 0;
        List<PowerThread> threadList = new ArrayList<>();
        units.forEach(unit -> {
            PowerThread newPowerThread = new PowerThread(unit);
            newPowerThread.start();
            threadList.add(newPowerThread);
        });
        for (var thread : threadList) {
            thread.join();
            totalPower += thread.getPower();
        }
        return totalPower;
    }
}
