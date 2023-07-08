package faang.school.godbless.sword_and_magic;

import java.util.ArrayList;
import java.util.List;


public class Army {
    List<Unit> mages = new ArrayList<>();
    List<Unit> archers = new ArrayList<>();
    List<Unit> swordsmen = new ArrayList<>();
    private List<Unit> unit;

    public Army(List<Unit> unit) {
        this.unit = unit;
    }

    public int calculateTotalPower() throws InterruptedException {
        for (Unit unit : unit) {
            if (unit.isMage()) {
                mages.add(unit);
            } else if (unit.isArcher()) {
                archers.add(unit);
            } else if (unit.isSwordsman()) {
                swordsmen.add(unit);
            }
        }


        List<PowerThread> mageThreads = new ArrayList<>();

        for (Unit mage : mages) {
            PowerThread powerThread = new PowerThread(mage);    //Запускаю поток для каждого рода войск
            mageThreads.add(powerThread);
            powerThread.start();
        }

        List<PowerThread> archerThreads = new ArrayList<>();

        for (Unit archer : archers) {
            PowerThread powerThread = new PowerThread(archer);
            archerThreads.add(powerThread);
            powerThread.start();
        }

        List<PowerThread> swordsmenThreads = new ArrayList<>();

        for (Unit swordsman : swordsmen) {
            PowerThread powerThread = new PowerThread(swordsman);
            swordsmenThreads.add(powerThread);
            powerThread.start();
        }

        int totalMagePower = 0;
        for (PowerThread mageThread : mageThreads) {
            mageThread.join();
            totalMagePower += mageThread.getPower();    //Подсчет power каждого рода войск
        }

        int totalArcherPower = 0;
        for (PowerThread archerThread : archerThreads) {
            archerThread.join();
            totalArcherPower += archerThread.getPower();
        }

        int totalSwordsmanPower = 0;
        for (PowerThread swordsmanThread : swordsmenThreads) {
            swordsmanThread.join();
            totalSwordsmanPower += swordsmanThread.getPower();
        }

        System.out.println("Mage = " + totalMagePower);

        return 0;
    }
}
