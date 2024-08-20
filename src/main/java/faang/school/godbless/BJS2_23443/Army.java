package faang.school.godbless.BJS2_23443;

import java.util.ArrayList;
import java.util.List;

public class Army {

    List<PowerThread> mageThreads = new ArrayList<>();
    List<PowerThread> archerThreads = new ArrayList<>();
    List<PowerThread> swordsmanThreads = new ArrayList<>();
    private final List<Unit> units;

    public Army(List<Unit> units) {
        this.units = units;
    }

    public int calculateTotalPower() throws InterruptedException {

        for (Unit unit : units) {
            if (unit.isMage()) {
                startThread(unit);
            } else if (unit.isArcher()) {
                startThread(unit);
            } else if (unit.isSwordsman()) {
                startThread(unit);
            }
        }

        int totalMagePower = getPowerSum(mageThreads);
        int totalArcherPower = getPowerSum(archerThreads);
        int totalSwordsmanPower = getPowerSum(swordsmanThreads);

        return totalArcherPower + totalMagePower + totalSwordsmanPower;
    }

    private void startThread(Unit unit) {
        PowerThread powerThread = new PowerThread(unit);
        mageThreads.add(powerThread);
        powerThread.start();
    }

    private int getPowerSum(List<PowerThread> units) throws InterruptedException {
        int totalPower = 0;
        for (PowerThread unitThread : units) {
            unitThread.join();
            totalPower += unitThread.getPower();
        }
        return totalPower;
    }


}
