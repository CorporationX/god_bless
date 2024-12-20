package school.faang.task_47827;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

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
            try {
                t.join();
            } catch (InterruptedException e) {
                System.err.println("Thread execution was interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }

        for (PowerCalculator task : tasks) {
            totalPower += task.getPower();
        }

        return totalPower;
    }
}