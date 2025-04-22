package school.faang.distributed_armsey_hero_me_i_magia;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Army {
    private final List<Squad> squads = new CopyOnWriteArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() {
        ExecutorService executor = Executors.newFixedThreadPool(
                Math.min(squads.size(), Runtime.getRuntime().availableProcessors() * 2)
        );

        try {
            List<Future<Integer>> futures = squads.stream()
                    .map(squad -> executor.submit(squad::calculateSquadPower))
                    .toList();

            return futures.stream()
                    .mapToInt(future -> {
                        try {
                            return future.get();
                        } catch (InterruptedException | ExecutionException e) {
                            Thread.currentThread().interrupt();
                            throw new RuntimeException("Error calculating squad power", e);
                        }
                    })
                    .sum();
        } finally {
            executor.shutdown();
        }
    }
}