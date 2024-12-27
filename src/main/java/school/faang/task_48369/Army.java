package school.faang.task_48369;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> units;

    public Army() {
        this.units = new ArrayList<>();
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() {
        int totalPower = 0;
        List<Thread> threads = new ArrayList<>();
        List<PowerCalculator> tasks = new ArrayList<>();

        for (Unit unit : units) {
            PowerCalculator calculator = new PowerCalculator(unit);
            tasks.add(calculator);
            Thread thread = new Thread(calculator);
            threads.add(thread);
            thread.start();
            System.out.println("Thread " + thread.getId() + " started for unit with power: " + unit.getPower());
        }

        for (Thread thread : threads) {
            try {
                thread.join();
                System.out.println("Thread " + thread.getId() + " finished.");
            } catch (InterruptedException e) {
                System.err.println("Thread " + thread.getId() + " was interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }

        for (PowerCalculator task : tasks) {
            totalPower += task.getPower();
        }

        return totalPower;
    }

}

