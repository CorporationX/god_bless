package school.faang.sprint3.distributedarmy;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<UnitThread> mageThreads = new ArrayList<>();
    private List<UnitThread> archerThreads = new ArrayList<>();
    private List<UnitThread> swordsmanThreads = new ArrayList<>();
    private List<Unit> units;

    public Army(List<Unit> units) {
        this.units = units;
    }

    public int calculateTotalPower() throws InterruptedException {
        for (Unit unit : units) {
            if (unit.isMage()) {
                startThreads(unit);
            } else if (unit.isArcher()) {
                startThreads(unit);
            } else if (unit.isSwordsman()) {
                startThreads(unit);
            }
        }
        return getTotal();
    }

    public int getTotal() throws InterruptedException {
        int totalMagePower = getPowerSum(mageThreads);
        int totalSwordsmanPower = getPowerSum(swordsmanThreads);
        int totalArcherPower = getPowerSum(archerThreads);
        System.out.println("Mage = " + totalMagePower);
        System.out.println("Archer = " + totalArcherPower);
        System.out.println("Swordsman = " + totalSwordsmanPower);
        return totalMagePower + totalArcherPower + totalSwordsmanPower;
    }

    private void startThreads(Unit unit) {
        UnitThread powerThread = new UnitThread(unit);
        if (unit.isMage()) {
            mageThreads.add(powerThread);
        } else if (unit.isArcher()) {
            archerThreads.add(powerThread);
        } else if (unit.isSwordsman()) {
            swordsmanThreads.add(powerThread);
        }
        powerThread.start();
    }

    private int getPowerSum(List<UnitThread> units) throws InterruptedException {
        int totalpower = 0;
        for (UnitThread mageThread : units) {
            mageThread.join();
            totalpower += mageThread.getPower();
        }
        return totalpower;
    }
}


