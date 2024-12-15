package school.faang.task_47775;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    private final List<Warrior> warriors = new ArrayList<>();

    public void addUnit(Warrior warrior) {
        if (warrior == null) {
            throw new NullPointerException("warrior is null");
        }
        warriors.add(warrior);
    }

    public int calculateTotalPower() {
        AtomicInteger totalPower = new AtomicInteger();
        ExecutorService executor = Executors.newFixedThreadPool(warriors.size());
        for (Warrior warrior : warriors) {
            executor.submit(() -> totalPower.addAndGet(warrior.getPower()));
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return totalPower.get();
    }
}
