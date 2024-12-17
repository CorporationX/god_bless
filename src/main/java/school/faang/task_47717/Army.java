package school.faang.task_47717;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<PowerThread> mageThreads = new ArrayList<>();
    private List<PowerThread> swordsmanThreads = new ArrayList<>();
    private List<PowerThread> archerThreads = new ArrayList<>();
    private final List<Unit> unitsList = new ArrayList<>();

    public void addUnit(Unit unit) {
        unitsList.add(unit);
    }

    public int calculateTotalPower() {

        for (Unit unit : unitsList) {
            if (unit.isMage()) {
                startThread(unit);
            } else if (unit.isSwordsman()) {
                startThread(unit);
            } else if (unit.isArcher()) {
                startThread(unit);
            }
        }

        try {
            return getTotal();
        } catch (InterruptedException e) {
            return 0;
        }
    }

    private void startThread(Unit unit) {
        PowerThread powerThread = new PowerThread(unit);
        mageThreads.add(powerThread);
        powerThread.start();
    }

    private int getTotal() throws InterruptedException {
        int totalMagePower = getPowerSum(mageThreads);
        int totalArcherPower = getPowerSum(archerThreads);
        int totalSwordsmanPower = getPowerSum(swordsmanThreads);

        return totalArcherPower + totalSwordsmanPower + totalMagePower;
    }

    private int getPowerSum(List<PowerThread> units) throws InterruptedException {
        int totalPower = 0;
        for (PowerThread mageThread : units) {
            mageThread.join();
            totalPower += mageThread.getPower();
        }

        return totalPower;
    }
}
