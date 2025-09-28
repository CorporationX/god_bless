package school.faang.bjs2_92928;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class PotionGathering {
    private static final int COUNT_THREADS = 4;
    private static final int AWAIT_TERMINATION_MIN = 1;

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        ExecutorService executor = Executors.newFixedThreadPool(COUNT_THREADS);
        Gatherer gatherer = new Gatherer();

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(
                        () -> gatherer.gatherIngredients(potion), executor
                ))
                .toList();

        CompletableFuture<Void> allDone =
                CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        int totalIngredients = allDone.thenApply(v ->
                futures.stream()
                        .mapToInt(CompletableFuture::join)
                        .sum()
        ).join();

        log.info("Общее количество собранных ингредиентов: {}", totalIngredients);

        shutdown(executor);
    }

    private static void shutdown(ExecutorService executor) {
        executor.shutdown();

        try {
            if (!executor.awaitTermination(AWAIT_TERMINATION_MIN, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
        }
    }
}
