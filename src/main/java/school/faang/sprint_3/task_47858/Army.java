package school.faang.sprint_3.task_47858;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Unit> units = new ArrayList<>();

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

        for (Thread t : threads) {
            t.join();
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
