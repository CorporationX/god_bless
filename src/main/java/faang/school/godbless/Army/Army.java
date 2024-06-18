package faang.school.godbless.Army;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Army {

    List<PowerThread> swordsmenThread = new ArrayList<>();
    List<PowerThread> archerThread = new ArrayList<>();
    List<PowerThread> mageThreads = new ArrayList<>();

    private final List<Unit> units;

    public Army(List<Unit> units) {
        this.units = units;
    }

    public void processUnit(Unit unit, List<PowerThread> threadList){
        PowerThread powerThread = new PowerThread(unit);
        threadList.add(powerThread);
        powerThread.start();
    }

    int calculateTotalPower() throws InterruptedException {

        for (Unit unit : units) {
            if (unit.isMage()) {
                processUnit(unit, mageThreads);
            } else if (unit.isArcher()) {
                processUnit(unit, archerThread);
            } else if (unit.isSwordsMan()) {
                processUnit(unit, swordsmenThread);
            }
        }
        return getTotal();
    }

    private int getTotal() throws  InterruptedException {
        int totalMagePower = getPowerSum(mageThreads);
        int totalArcherPower = getPowerSum(archerThread);
        int totalSwordsPower = getPowerSum(swordsmenThread);


        System.out.println("Mage" + totalMagePower);
        System.out.println("Archer" + totalArcherPower);
        System.out.println("Swords" + totalSwordsPower);

        return totalMagePower + totalArcherPower + totalSwordsPower;
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


