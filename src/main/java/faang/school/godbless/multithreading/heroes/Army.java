package faang.school.godbless.multithreading.heroes;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Army {

    private List<PowerThread> archerThreads;
    private List<PowerThread> mageThreads;
    private List<PowerThread> swordsmenThreads;

    public Army() {
        this.archerThreads = new ArrayList<>();
        this.mageThreads = new ArrayList<>();
        this.swordsmenThreads = new ArrayList<>();
    }

    public int calculateTotalPower() {
        var totalArchersPower = getTotalPower(archerThreads);
        var totalMagesPower = getTotalPower(mageThreads);
        var totalSwordsmanPower = getTotalPower(swordsmenThreads);

        System.out.println("Total archers power: " + totalArchersPower);
        System.out.println("Total mages power: " + totalMagesPower);
        System.out.println("Total swordsman power: " + totalSwordsmanPower);

        return totalArchersPower + totalMagesPower + totalSwordsmanPower;
    }

    private int getTotalPower(List<PowerThread> powerThreads) {
        int totalPower = 0;
        for (PowerThread soldier : powerThreads) {
            try {
                soldier.join();
                totalPower += soldier.getPower();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return totalPower;
    }

    public void addSoldier(Soldier soldier) {
        if (soldier.isMage()) {
            var mageThread = new PowerThread(soldier);
            this.mageThreads.add(mageThread);
            mageThread.start();
        } else if (soldier.isArcher()) {
            var archerThread = new PowerThread(soldier);
            this.archerThreads.add(archerThread);
            archerThread.start();
        } else if (soldier.isSwordsman()) {
            var swordsmanThread = new PowerThread(soldier);
            this.swordsmenThreads.add(swordsmanThread);
            swordsmanThread.start();
        } else {
            throw new IllegalArgumentException("Unknown soldier type");
        }
    }

}
