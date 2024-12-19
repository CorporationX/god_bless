package school.faang.task_48448;

import java.util.ArrayList;
import java.util.List;

public class Army {

    public List<Unit> army = new ArrayList<>();

    public void addUnit(Unit unit) {
        army.add(unit);
    }

    public int calculateTotalPower() {

        int powerTotal = 0;

        List<Thread> threads = new ArrayList<>();
        List<PowerCalculator> powerCalculators = new ArrayList<>();

        for (Unit unit : army) {
            PowerCalculator powerCalculator = new PowerCalculator(unit);
            powerCalculators.add(powerCalculator);
            Thread thread = new Thread(powerCalculator);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("!!!Exception!!! " + e);
            }
        }

        for (PowerCalculator powerCalculator : powerCalculators) {
            powerTotal = powerTotal + powerCalculator.getPower();
        }
        return powerTotal;
    }
}
