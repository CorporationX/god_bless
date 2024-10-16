package school.faang.multithreading.distributedArmy;


import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Unit> armyList = new ArrayList<>();

    public void addUnit(Unit unit) {
        armyList.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException {
        int totalPower = 0;
        List<PowerCalculation> powerCalculationList = new ArrayList<>();
        List<Thread> threadList = new ArrayList<>();

        for (Unit unit : armyList) {
            PowerCalculation powerCalculation = new PowerCalculation(unit);
            Thread thread = new Thread(powerCalculation);

            powerCalculationList.add(powerCalculation);
            threadList.add(thread);
            thread.start();
        }

        for (Thread thread : threadList) {
            thread.join();
        }

        for (PowerCalculation powerCalculation : powerCalculationList) {
            totalPower += powerCalculation.getPower();
        }
        return totalPower;
    }

}
