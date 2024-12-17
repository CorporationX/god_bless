package school.faang.bjs247755;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    private static final List<Unit> units = new ArrayList<>();

    public static int calculateTotalPower() {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        AtomicInteger result = new AtomicInteger();
        units.forEach(unit -> {
            executor.submit(() -> {
                result.addAndGet(unit.getPower());
            });
        });

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, java.util.concurrent.TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        return result.get();
    }

    public static int calculateTotalPowerInThreads() {
        AtomicInteger result = new AtomicInteger();
        List<ThreadUnitPowerCalculator> threads = new ArrayList<>();

        for (Unit unit : units) {
            ThreadUnitPowerCalculator thread = new ThreadUnitPowerCalculator(unit, result);
            threads.add(thread);
            thread.start();
        }

        for (ThreadUnitPowerCalculator thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return result.get();
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(20));

        int totalPower = calculateTotalPowerInThreads();
        System.out.println("Общая сила армии: " + totalPower);
    }
}
