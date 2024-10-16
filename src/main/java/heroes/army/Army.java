package heroes.army;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Unit> unitList;

    public Army(List<Unit> unitList) {
        this.unitList = unitList;
    }

    public int calculateTotalPower() throws InterruptedException {
        int totalPower = 0;
        List<Thread> threadList = new ArrayList<>();
        List<PowerCalculator> powerCalculatorList = new ArrayList<>();
        for (Unit unit : unitList) {
            PowerCalculator powerCalculator = new PowerCalculator(unit);
            powerCalculatorList.add(powerCalculator);
            Thread thread = new Thread(powerCalculator);
            threadList.add(thread);
            thread.start();
        }
        for (Thread thread : threadList) {
            thread.join();
        }
        for (PowerCalculator powerCalculator : powerCalculatorList) {
            totalPower += powerCalculator.getPower();
        }
        return totalPower;
    }
}