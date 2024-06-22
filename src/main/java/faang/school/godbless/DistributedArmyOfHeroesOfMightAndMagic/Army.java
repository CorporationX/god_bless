package faang.school.godbless.DistributedArmyOfHeroesOfMightAndMagic;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Army {
    private final List<Units> allUnits = new ArrayList<>();
    private int totalPower = 0;

    public int calculateTotalPower() throws InterruptedException {
        System.out.println("Start counting total power");
        List<Thread> threads = new ArrayList<>();

        for (Units unit : allUnits) {
            Thread currentThread = new Thread(new calculatePowerOfType(unit));
            threads.add(currentThread);
            currentThread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new InterruptedException();
            }
        }
        System.out.println("End counting total power");
        return totalPower;
    }

    public void addUnit(Units unit) {
        allUnits.add(unit);
    }

    private class calculatePowerOfType extends Thread {
        private final Units unit;

        @Override
        public void run() {
            System.out.println("Start counting Power of " + unit.getType());
            totalPower += unit.getPower();
            System.out.println("End counting Power of " + unit.getType());
        }

        public calculatePowerOfType(Units unit) {
            this.unit = unit;
        }
    }
}
