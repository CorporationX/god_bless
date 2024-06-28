package faang.school.godbless.BJS2_11048;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> units;
    private final List<PowerThread> archerThreads;
    private final List<PowerThread> mageThreads;
    private final List<PowerThread> swordsmanThreads;

    public Army() {
        units = new ArrayList<>();
        archerThreads = new ArrayList<>();
        mageThreads = new ArrayList<>();
        swordsmanThreads = new ArrayList<>();
    }

    protected void addUnit(Unit unit) {
        units.add(unit);
    }

    protected int calculateTotalPower() throws InterruptedException {
        for (Unit unit : units) {
            if (unit.isMage()) {
                startThreads(unit, mageThreads);
            } else if (unit.isArcher()) {
                startThreads(unit, archerThreads);
            } else if (unit.isSwordsman()) {
                startThreads(unit, swordsmanThreads);
            }
        }
        return getTotal();
    }

    private int getTotal() throws InterruptedException {
        int totalMagePower = getPowerSum(mageThreads);
        int totalArcherPower = getPowerSum(archerThreads);
        int totalSwordsmanPower = getPowerSum(swordsmanThreads);


        System.out.println("Mage = " + totalMagePower);
        System.out.println("Archer = " + totalArcherPower);
        System.out.println("Swordsman = " + totalSwordsmanPower);

        return totalArcherPower + totalMagePower + totalSwordsmanPower;
    }

    private void startThreads(Unit unit, List<PowerThread> unitThreads) {
        PowerThread powerThread = new PowerThread(unit);
        unitThreads.add(powerThread);
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
