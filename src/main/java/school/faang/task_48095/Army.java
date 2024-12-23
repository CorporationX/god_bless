package school.faang.task_48095;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException {
        int totalPower = 0;

        List<Thread> threads = new ArrayList<>();
        List<PowerCalculator> powerCalculators = new ArrayList<>();

        for (Unit unit : units) {
            PowerCalculator powerCalculator = new PowerCalculator(unit);
            Thread thread = new Thread(powerCalculator);
            threads.add(thread);
            powerCalculators.add(powerCalculator);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        for (PowerCalculator powerCalculator : powerCalculators) {
            totalPower += powerCalculator.getResult();
        }

        return totalPower;
    }

    private static class PowerCalculator implements Runnable {
        private final Unit unit;
        @Getter
        private int result;

        public PowerCalculator(Unit unit) {
            this.unit = unit;
        }

        @Override
        public void run() {
            result = unit.getPower();
        }
    }
}
