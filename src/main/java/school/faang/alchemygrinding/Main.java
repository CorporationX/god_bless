package school.faang.alchemygrinding;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int SLEEP_TIME = 2000;
    private static final int THREAD_COUNT = 4;
    private static final ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

    public static void main(String[] args) throws InterruptedException {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );
        // Асинхронный сбор ингредиентов
        gatherAllIngredients(potions);
    }

    private static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futureTasks = potions.stream()
                .map(p -> CompletableFuture.supplyAsync(() -> gatherIngredients(p), executor))
                .toList();
        CompletableFuture<Integer> sumFuture = CompletableFuture.allOf(futureTasks.toArray(new CompletableFuture[0]))
                .thenApply(v -> futureTasks.stream()
                        .mapToInt(CompletableFuture::join)
                        .sum());
        System.out.printf("Total ingredients gathered: %d\n", sumFuture.join());

        executor.shutdown();
        try {
            if (!executor.awaitTermination(2, TimeUnit.SECONDS)) {
                log.info("Shutting down executor...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread was interrupted", e);
            throw new RuntimeException("Thread was interrupted", e);
        }
    }

    public static int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(SLEEP_TIME);
            return potion.requiredIngredients();
        } catch (InterruptedException e) {
            log.error("Thread was interrupted while sleeping", e);
            throw new RuntimeException("Thread was interrupted while sleeping", e);
        }
    }
}
