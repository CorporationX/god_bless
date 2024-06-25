package faang.school.godbless.BJS2_11048;

import java.util.ArrayList;
import java.util.List;

public class Army {
    List<Unit> units = new ArrayList<>();


    List<PowerThread> archerThreads = new ArrayList<>();
    List<PowerThread> mageThreads = new ArrayList<>();
    List<PowerThread> swordsmanThreads = new ArrayList<>();


    protected void addUnit(Unit unit) {
        units.add(unit);
    }

    protected int calculateTotalPower() throws InterruptedException {
        for (Unit unit : units) {
            if (unit.isMage()) {
                PowerThread powerThread = new PowerThread(unit);
                mageThreads.add(powerThread);
                powerThread.start();
            } else if (unit.isArcher()) {
                PowerThread powerThread = new PowerThread(unit);
                archerThreads.add(powerThread);
                powerThread.start();
            } else if (unit.isSwordsman()) {
                PowerThread powerThread = new PowerThread(unit);
                swordsmanThreads.add(powerThread);
                powerThread.start();
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
