package faang.school.godbless.Army;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Army {

    List<Unit> mages = new ArrayList<>();
    List<Unit> archers = new ArrayList<>();
    List<Unit> swordsmen = new ArrayList<>();

    List<PowerThread> magesThreads = new ArrayList<>();

    private List<Unit> units;

    public Army(List<Unit> units) {
        this.units = units;
    }

    int calculateTotalPower() throws InterruptedException {
        for (Unit unit : units) {
            if (unit.isMage()) {
                mages.add(unit);
            } else if (unit.isArcher()) {
                archers.add(unit);
            } else if (unit.isSwordsMan()) {
                swordsmen.add(unit);
            }
        }


        List<PowerThread> mageThreads = new ArrayList<>();

        for (Unit mage : mages) {
            PowerThread powerThread = new PowerThread(mage);
            mageThreads.add(powerThread);
            powerThread.start();
        }

        List<PowerThread> archerThread = new ArrayList<>();

        for (Unit archer : archers) {
            PowerThread powerThread = new PowerThread(archer);
            archerThread.add(powerThread);
            powerThread.start();
        }

        List<PowerThread> swordsmenThread = new ArrayList<>();

        for (Unit swordsman : swordsmen) {
            PowerThread powerThread = new PowerThread(swordsman);
            swordsmenThread.add(powerThread);
            powerThread.start();
        }

        int totalMagePower = 0;
        for (PowerThread mageThread : mageThreads) {
            try {
                mageThread.join();
                totalMagePower += mageThread.getPower();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int totalArcherPower = 0;
        for (PowerThread archerThreads : archerThread) {
            try {
                archerThreads.join();
                totalArcherPower += archerThreads.getPower();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int totalSwordsmanPower = 0;
            for (PowerThread swordThread : swordsmenThread) {
                try {
                    swordThread.join();
                    totalSwordsmanPower += swordThread.getPower();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Mage = " + totalMagePower);
            System.out.println("Archer = " + totalArcherPower);
            System.out.println("Swordsmen =" + totalSwordsmanPower);


            return 0;
        }
    }


