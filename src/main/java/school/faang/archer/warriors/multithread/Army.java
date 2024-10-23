package school.faang.archer.warriors.multithread;

import java.util.ArrayList;
import java.util.List;

public class Army {
    List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() {
        int[] results = new int[units.size()];
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < units.size(); i++) {
            PowerCalculator powerCalculator = new PowerCalculator(units.get(i), results, i);
            threads.add(powerCalculator);
            powerCalculator.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int totalPower = 0;
        for (int result : results) {
            totalPower += result;
        }

        return totalPower;
    }
}
