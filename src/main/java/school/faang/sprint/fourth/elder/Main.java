package school.faang.sprint.fourth.elder;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_SLEEP_TIME = 1000;
    private static final int AWAIT_THREAD_TERMINATION_TIME = 3;
    private static final int THREAD_COUNT = 3;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(THREAD_COUNT);

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        // Асинхронный сбор ингредиентов
        gatherAllIngredients(potions);
    }

    private static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> completableFutureList = potions.parallelStream()
                .map(Main::getRequiredIngredients).toList();

        CompletableFuture<Void> allOfCompletableFuture =
                CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[0]));

        allOfCompletableFuture.thenRun(() -> {
            int totalNumberOfDependents = completableFutureList.stream()
                    .mapToInt(CompletableFuture::join).sum();
            log.info("Total number of dependents: {}", totalNumberOfDependents);
        }).join();

        shutdown();
    }

    private static CompletableFuture<Integer> getRequiredIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("Gathering ingredients for {}", potion.getName());
            try {
                Thread.sleep(THREAD_SLEEP_TIME);
            } catch (InterruptedException e) {
                log.error("Thread interrupted: {}", e.getMessage());
            }
            return potion.getRequiredIngredients();
        }, EXECUTOR);
    }

    private static void shutdown() {
        EXECUTOR.shutdown();
        try {
            if (!EXECUTOR.awaitTermination(AWAIT_THREAD_TERMINATION_TIME, TimeUnit.SECONDS)) {
                EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.info("Thread interrupted: {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
