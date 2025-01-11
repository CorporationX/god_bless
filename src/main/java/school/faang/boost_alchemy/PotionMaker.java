package school.faang.boost_alchemy;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionMaker {
    private static final long THREAD_SLEEP_TIME = 1000L;
    private static final int THREAD_POOL_SIZE = 5;
    @Getter
    private final AtomicInteger totalIngredients = new AtomicInteger(0);
    private final ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public void countAllIngredients(List<Potion> potions) {
        potions.stream()
                .map(potion -> gatherIngredients(potion)
                        .thenApply(countedIngredients -> {
                            totalIngredients.addAndGet(countedIngredients);
                            return countedIngredients;
                        }))
                .forEach(CompletableFuture::join);
        shutdownThreadPool(executor);
    }

    private CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            takeTimeForGathering();
            log.info("Potion {} counted", potion.getName());
            return potion.getRequiredIngredients();
        }, executor);
    }

    private void takeTimeForGathering() {
        try {
            Thread.sleep((long) (THREAD_SLEEP_TIME * (Math.random() + 0.1)));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread {} error", Thread.currentThread().getName());
        }
    }

    private void shutdownThreadPool(ExecutorService executor) {
        executor.shutdown();
        try {
            if (executor.awaitTermination(10, TimeUnit.SECONDS)) {
                log.info("All tasks completed without errors");
            } else {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Tasks completed with errors {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}