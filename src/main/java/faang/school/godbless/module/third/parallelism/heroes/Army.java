package faang.school.godbless.module.third.parallelism.heroes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import faang.school.godbless.module.third.parallelism.heroes.creature.Creature;

public class Army {
    private int totalPower = 0;
    private List<Creature> army = new ArrayList<>();
    
    public void addUnit(Creature creature) {
        army.add(creature);
    }
    
    public int calculateTotalPower() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (Creature creature : army) {
            executorService.execute(() -> addPower(creature.getPower()));
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return totalPower;
    }
    
    private synchronized void addPower(int power) {
        totalPower += power;
    }
}
