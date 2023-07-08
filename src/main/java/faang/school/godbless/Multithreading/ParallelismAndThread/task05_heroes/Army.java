package faang.school.godbless.Multithreading.ParallelismAndThread.task05_heroes;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

@Data
@AllArgsConstructor
public class Army {

    List<Unit> archerList = new ArrayList<>();
    List<Unit> swordsmanList = new ArrayList<>();
    List<Unit> mageList = new ArrayList<>();

    public Army(List<Unit> units) {
        this.units = units;
    }

    private List<Unit> units;

    public int calculateTotalPower() throws InterruptedException {
        List<PowerThread> archerThreads = new ArrayList<>();
        List<PowerThread> swordsmanThreads = new ArrayList<>();
        List<PowerThread> mageThreads = new ArrayList<>();

        for (Unit unit : units) {
            if (unit == null) {
                throw new IllegalArgumentException("Лист пуст");
            }
            if (unit.isArcher()) {
                PowerThread powerThread = new PowerThread(unit);
                archerThreads.add(powerThread);
                powerThread.start();
            } else if (unit.isSwordsman()) {
                PowerThread powerThread = new PowerThread(unit);
                swordsmanThreads.add(powerThread);
                powerThread.start();
            } else if (unit.isMage()) {
                PowerThread powerThread = new PowerThread(unit);
                mageThreads.add(powerThread);
                powerThread.start();
            }
        }

        int tatalMagePower = getPowerSum(mageThreads);
        int totalArcherPower = getPowerSum(archerThreads);
        int totalSwordMan = getPowerSum(swordsmanThreads);

        System.out.println("Mage power = "+tatalMagePower);
        System.out.println("Archer power = "+totalArcherPower);
        System.out.println("Swordman power = "+totalSwordMan);

        return totalSwordMan + totalArcherPower + tatalMagePower;
    }
    private int getPowerSum(List<PowerThread> units) throws InterruptedException {
        int totalPower = 0;
        for(PowerThread thread : units) {
            thread.join();
            totalPower += thread.getPower();
        }
        return totalPower;
    }
}
