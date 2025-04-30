package alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static ExecutorService executor;
    private static final int POOL_SIZE = 4;
    private static final int TIMEOUT = 1;
    private static List<Potion> potions =
            List.of(new Potion("Love potion", 2),
                    new Potion("ToFrog potion", 3),
                    new Potion("Fly potion", 4));

    public static void main(String[] args) {
        executor = Executors.newFixedThreadPool(POOL_SIZE);
        List<CompletableFuture<Integer>> completableList = potions.stream()
                .map(Main::gatherIngredients)
                .toList();

        int sumOfIngredients = CompletableFuture.allOf(
                completableList.toArray(new CompletableFuture[0])
        ).thenApply(v -> completableList.stream()
                .map(CompletableFuture::join)
                .mapToInt(Integer::intValue)
                .sum()
        ).join();

        System.out.printf("All potions are ready and sum of ingredients is %d.", sumOfIngredients);
        softShutdown(executor);

    }

    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        if (Objects.isNull(potion)) {
            log.error("Your potion is null!");
            throw new IllegalArgumentException();
        }
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("Method gatherIngredients starts...");
                Thread.sleep(potion.getRequiredIngredients() * 1000L);
            } catch (InterruptedException e) {
                log.error("Thread is interrupted! {}", e.getCause().getMessage());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            return potion.getRequiredIngredients();
        }, executor);
    }

    private static void softShutdown(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.warn("Thread isn t terminated in time! Forced Shutdown!");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Player thread is interrupted! {}", e.getCause().getMessage());
            Thread.currentThread().interrupt();
            throw new RuntimeException();
        }
    }
}
