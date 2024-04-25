package faang.school.godbless.homm;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Army {

    private final List<Unit> units = new ArrayList<>();

    public int calculateTotalPower() throws InterruptedException {
        List<PowerThread> archersThreads = new ArrayList<>();
        List<PowerThread> swordsmenThreads = new ArrayList<>();
        List<PowerThread> mageThreads = new ArrayList<>();

        for (Unit unit : units) {
            if (unit.isArcher()) {
                PowerThread powerThread = new PowerThread(unit);
                archersThreads.add(powerThread);
                powerThread.start();
            } else if (unit.isSwordsman()) {
                PowerThread powerThread = new PowerThread(unit);
                swordsmenThreads.add(powerThread);
                powerThread.start();
            } else if (unit.isMage()) {
                PowerThread powerThread = new PowerThread(unit);
                mageThreads.add(powerThread);
                powerThread.start();
            }
        }

        int totalArchersPower = getTotalPower(archersThreads);
        int totalSwordsmenPower = getTotalPower(swordsmenThreads);
        int totalMagesPower = getTotalPower(mageThreads);

        System.out.println("Archers total power: " + totalArchersPower);
        System.out.println("Swordsmen total power: " + totalSwordsmenPower);
        System.out.println("Mage total power: " + totalMagesPower);

        return totalArchersPower + totalSwordsmenPower + totalMagesPower;
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    private int getTotalPower(List<PowerThread> units) throws InterruptedException {
        int totalPower = 0;
        for (PowerThread unitThread : units) {
            unitThread.join();
            totalPower += unitThread.getPower();
        }
        return totalPower;
    }
}
