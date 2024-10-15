package school.faang.heroes;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Object> units = new ArrayList<>();

    public void addUnit(Object unit) {
        units.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException {
        int totalUnits = units.size();
        int totalPower = 0;

        List<PowerCalculator> calculators = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        for (Object unit : units) {
            PowerCalculator calculator = new PowerCalculator(unit);
            calculators.add(calculator);
            Thread thread = new Thread(calculator);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        for (PowerCalculator calculator : calculators) {
            totalPower += calculator.getPower();
        }

        return totalPower;
    }
}
