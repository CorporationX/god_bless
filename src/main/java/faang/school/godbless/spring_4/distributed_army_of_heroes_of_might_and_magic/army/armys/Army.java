package faang.school.godbless.spring_4.distributed_army_of_heroes_of_might_and_magic.army.armys;

import faang.school.godbless.spring_4.distributed_army_of_heroes_of_might_and_magic.GatheringPower;
import faang.school.godbless.spring_4.distributed_army_of_heroes_of_might_and_magic.army.Divisions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Army {
    private int sizePool = 4;
    private final ExecutorService pool = Executors.newFixedThreadPool(sizePool);
    private final List<Divisions> divisions = new ArrayList<>();

    public void setSizePool(int sizePool) {
        this.sizePool = sizePool;
    }

    public int calculateTotalPower() throws InterruptedException, ExecutionException {
        List<Future<Integer>> answers = new ArrayList<>();

        for (Divisions division : divisions) {
            answers.add(pool.submit(new GatheringPower(division)));
            pool.submit(new GatheringPower(division));
        }

        terminationOfThreads();
        int count = 0;
        for (Future<Integer> answer : answers) {
            count += answer.get();
        }

        return count;
    }

    private void terminationOfThreads() {
        pool.shutdown();
        try {
            if (!pool.awaitTermination(1, TimeUnit.SECONDS)) {
                pool.shutdownNow();
            }
        } catch (InterruptedException e) {
            pool.shutdownNow();
        }
    }

    public void addUnit(Divisions division) throws InterruptedException {
        divisions.add(division);
    }
}
