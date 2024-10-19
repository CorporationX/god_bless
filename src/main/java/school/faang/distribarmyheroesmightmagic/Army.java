package school.faang.distribarmyheroesmightmagic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class Army {
    private final List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() {
        ExecutorService executor = Executors.newFixedThreadPool(units.size());

        List<Callable<Integer>> tasks = units.stream()
                .map(unit -> (Callable<Integer>) unit::getPower)
                .collect(Collectors.toList());

        try {
            List<Future<Integer>> results = executor.invokeAll(tasks);
            int totalPower = results.stream()
                    .mapToInt(future -> {
                        try {
                            return future.get();
                        } catch (InterruptedException | ExecutionException e) {
                            e.printStackTrace();
                            return 0;
                        }
                    })
                    .sum();

            return totalPower;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return 0;
        } finally {
            executor.shutdown();
        }
    }
}
