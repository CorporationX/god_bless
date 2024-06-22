package faang.school.godbless.BJS211122;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    private List<Creature> army = new ArrayList<>();
    private AtomicInteger armyPower = new AtomicInteger(0);
    public int calculateTotalPower() {
        armyPower.set(0);
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (Creature creature : army) {
            service.execute(() -> armyPower.addAndGet( creature.getPower() * creature.getQuantity()));
        }

        service.shutdown();

        try {
            if (!service.awaitTermination(10, TimeUnit.SECONDS)) {
                List<Runnable> unfinishedTasks = service.shutdownNow();
                unfinishedTasks.forEach(System.out::println);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            service.shutdownNow();
            throw new RuntimeException("Thread was interrupted: " + e.getMessage());
        }

        return armyPower.get();
    }

    public void addUnit(Creature creature) {
        army.add(creature);
    }
}
