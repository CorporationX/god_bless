package school.faang.sprint3.distributedarmy;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private List<Unit> units;

    public Army(List<Unit> units) {
        this.units = units;
    }

    public int calculateTotalPower() throws InterruptedException {
        int totalPower = 0;
        List<Thread> threads = new ArrayList<>();
        List<PowerCalculator> tasks = new ArrayList<>();

        for (Unit unit : units) {
            PowerCalculator calculator = new PowerCalculator(unit);
            tasks.add(calculator);
            Thread thread = new Thread(calculator);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        for (PowerCalculator task : tasks) {
            totalPower += task.getPower();
        }

        return totalPower;
    }

}


