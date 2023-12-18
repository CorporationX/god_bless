package faang.school.godbless.parallelism.army;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {

    private final List<Unit> units;
    private final AtomicInteger totalPower;
    List<Thread> threads;

    public Army() {
        units = new ArrayList<>();
        totalPower = new AtomicInteger(0);
        threads = new ArrayList<>();
    }

    public int calculateTotalPower() {
        startThreads();
        joinThreads();
        return totalPower.get();
    }

    private void joinThreads() {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }

    private void startThreads() {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (Unit unit : units) {
            Thread thread = new Thread(() -> {
                totalPower.addAndGet(unit.getPower());
                System.out.printf("Unit %s added with power: %d\n", unit.getClass().getSimpleName(), unit.getPower());
            });
            threads.add(thread);
            thread.start();
        }
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }

}
