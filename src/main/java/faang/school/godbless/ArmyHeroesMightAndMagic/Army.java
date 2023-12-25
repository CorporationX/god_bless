package faang.school.godbless.ArmyHeroesMightAndMagic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    private List<Unit> units = new ArrayList<>();


    public int calculateTotalPower() {
        ExecutorService executor = Executors.newCachedThreadPool();
        AtomicInteger allPower = new AtomicInteger(0);
        for (Unit unit : units) {
            executor.submit(() -> {
                allPower.addAndGet(unit.getPower());
                System.out.println(unit + " обрабатывается в потоке " + Thread.currentThread().getName());
            });
        }
        executor.shutdown();
        try {
            // Ждем завершения всех потоков
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return allPower.get();
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }
}
