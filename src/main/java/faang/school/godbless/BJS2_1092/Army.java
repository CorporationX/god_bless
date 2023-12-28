package faang.school.godbless.BJS2_1092;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Data
public class Army {
    private final Map<Creature, Integer> groupedArmy = new HashMap<>();

    public void addUnit(Creature creature) {
        groupedArmy.merge(creature, 1, Integer::sum);
    }

    public int calculateTotalPower() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<Integer>> futures = new ArrayList<>();

        for (var unit : groupedArmy.entrySet()) {
            Future<Integer> future = executorService.submit(() -> unit.getKey().getPower() * unit.getValue());
            futures.add(future);
        }

        executorService.shutdown();

        return futures.stream()
                .mapToInt(future -> {
                    try {
                        return future.get();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .sum();
    }
}