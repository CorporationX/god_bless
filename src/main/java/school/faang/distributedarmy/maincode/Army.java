package school.faang.distributedarmy.maincode;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException {
        int totalPower = 0;
        List<Thread> threads = new ArrayList<>();
        List<PowerCalculation> calculations = new ArrayList<>();

        for(Unit unit : units) {
            PowerCalculation calculator = new PowerCalculation(unit);
            calculations.add(calculator);
            Thread thread = new Thread(calculator);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        for (PowerCalculation calculation : calculations) {
            totalPower += calculation.getPower();
        }

        return totalPower;
    }
}
