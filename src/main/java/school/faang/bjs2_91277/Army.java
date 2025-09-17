package school.faang.bjs2_91277;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Army {
    private static final int DEFAULT_CORE_PROCESSOR = 3;
    private final List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() {
        ExecutorService executor = Executors.newFixedThreadPool(DEFAULT_CORE_PROCESSOR);

        try {
            List<Future<Integer>> futures = squads.stream()
                    .map(squad -> executor.submit(() -> squad.calculateSquadPower()))
                    .toList();

            return futures.stream()
                    .mapToInt(future -> {
                        try {
                            return future.get();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            log.error("Поток прерван", e);
                            return 0;
                        } catch (ExecutionException e) {
                            log.error("Ошибка при расчёте силы сквада", e);
                            return 0;
                        }
                    })
                    .sum();

        } finally {
            executor.shutdown();

            try {
                if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }
}
