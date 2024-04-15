package faang.school.godbless.distributed_army.model;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@AllArgsConstructor
public class Army {
    private List<Creature> army;

    public void addUnit(Creature creature) {
        army.add(creature);
    }

    public int calculateTotalPower() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Counter counter = new Counter();

        for (Creature creature : army) {
            executorService.submit(() -> counter.increment(creature.getPower()));
        }

        executorService.shutdown();
        return counter.getTotalCount();
    }
}