package faang.school.godbless.Army;

import java.util.ArrayList;
import java.util.List;

public class Army {
    List<Unit> units = new ArrayList<>();

    public int calculateTotalPower() throws InterruptedException {
        List<PowerCalculator> powerCalculators = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        int totalPower = 0;
        int index = 0;
        for (Unit unit : units) {
            powerCalculators.add(new PowerCalculator(unit));
            Thread thread = new Thread(powerCalculators.get(index++));
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        for (PowerCalculator calculator : powerCalculators) {
            totalPower += calculator.getPower();
        }
        return totalPower;
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }
}