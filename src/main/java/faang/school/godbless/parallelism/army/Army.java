package faang.school.godbless.parallelism.army;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {

    private final List<Unit> units;
    private final AtomicInteger totalPower = new AtomicInteger(0);
    List<Thread> threads = new ArrayList<>();

    public Army() {
        units = new ArrayList<>();
    }

    public int calculateTotalPower() {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (Unit unit : units) {
            Thread thread = new Thread(() -> {
                totalPower.addAndGet(unit.getPower());
                System.out.printf("Unit %s added with power: %d\n", unit.getClass().getSimpleName(), unit.getPower());
            });
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
        return totalPower.get();
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }

}
