package faang.school.godbless.spring_4.distributed_army_of_heroes_of_might_and_magic.army.armys;

import faang.school.godbless.spring_4.distributed_army_of_heroes_of_might_and_magic.army.Division;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Army {
    private final int SIZE_POOL = 4;
    private final ExecutorService pool = Executors.newFixedThreadPool(SIZE_POOL);
    private final Map<Division, Integer> divisionsAll = new HashMap<>();
    private final List<Division> divisions = new ArrayList<>();

    public int calculateTotalPower() {

        for (Division division : divisions) {
            pool.submit(() -> {
                if (divisionsAll.containsKey(division)) {
                    divisionsAll.put(division, divisionsAll.get(division) + division.getPower());
                } else {
                    divisionsAll.put(division, division.getPower());
                }
            });
        }

        terminationOfThreads();

        int count = 0;
        for (int value : divisionsAll.values()) {
            count += value;
        }

        return count;
    }

    private void terminationOfThreads() {
        pool.shutdown();
        try {
            if (!pool.awaitTermination(4, TimeUnit.SECONDS)) {
                pool.shutdownNow();
            }
        } catch (InterruptedException e) {
            pool.shutdownNow();
        }
    }

    public void addUnit(Division division) {
        divisions.add(division);
    }
}
