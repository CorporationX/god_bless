package school.faang.multithreadingarmy;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> unitList = new ArrayList<>();

    public int calculateTotalPower() throws InterruptedException {

        List<Thread> threadList = new ArrayList<>();
        List<PowerCalculator> powerCalculatorList = new ArrayList<>();

        unitList.forEach(unit -> {
            PowerCalculator powerCalculator = new PowerCalculator(unit);
            powerCalculatorList.add(powerCalculator);
            Thread thread = new Thread(powerCalculator);
            threadList.add(thread);
            thread.start();
        });

        for (Thread thread : threadList) {
            thread.join();
        }

        return powerCalculatorList.stream()
                .mapToInt(PowerCalculator::getPower)
                .sum();
    }

    public void addUnit(Unit unit) {
        unitList.add(unit);
    }
}
