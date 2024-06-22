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
            if (service.awaitTermination(10, TimeUnit.SECONDS)) {
                service.shutdown();
            }
        } catch (InterruptedException e) {
            service.shutdown();
            throw new RuntimeException("Something went wrong" + e);
        }

        return armyPower.get();
    }

    public void addUnit(Creature creature) {
        army.add(creature);
    }
}
