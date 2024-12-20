package school.faang.bjs248388;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> units = new ArrayList<>();

    public int calculateTotalPower() throws InterruptedException {
        int totalPower = 0;
        List<Thread> threads = new ArrayList<>();
        List<PowerCalculator> tasks = new ArrayList<>();
        PowerCalculator calculator;
        Thread thread;

        for (Unit unit : units) {
            calculator = new PowerCalculator(unit);
            tasks.add(calculator);
            thread = new Thread(calculator);
            threads.add(thread);
            thread.start();
        }

        for (Thread threadCurrent : threads) {
            threadCurrent.join();
        }

        for (PowerCalculator task : tasks) {
            totalPower += task.getPower();
        }

        return totalPower;
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }
}
