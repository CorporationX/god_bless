package school.faang.multithreading.async.bjs2_75069.alchemy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RequiredArgsConstructor
public class PotionCollector {
    private static final int ONE_SECOND_IN_MS = 1000;
    private final List<Potion> potionList;
    private final ExecutorService pool = Executors.newCachedThreadPool();

    private CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep((long) ONE_SECOND_IN_MS * potion.getRequaredIngredients());
            } catch (InterruptedException e) {
                log.error("Error during sleep, e={} ", e.getMessage());
                Thread.currentThread().interrupt();
            }
            return potion.getRequaredIngredients();
        }, pool);
    }

    public int gatherAllIngredients() {
        List<CompletableFuture<Integer>> futureList = potionList.stream()
                .map(this::gatherIngredients)
                .toList();
        AtomicInteger totalIngredients = new AtomicInteger(0);
        futureList.forEach(future -> future
                .thenAccept(result -> {
                    totalIngredients.addAndGet(result);
                    log.info("{} ingredients is collected", result);
                }));
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0])).join();
        shutdownPool();
        return totalIngredients.get();
    }

    private void shutdownPool() {
        pool.shutdown();
        try {
            if (!pool.awaitTermination(1, TimeUnit.MINUTES)) {
                log.warn("Force Termination.");
                pool.shutdownNow();
            } else {
                log.info("Execution is successfully finished.");
            }
        } catch (InterruptedException e) {
            log.error("Force Termination. InterruptedException = {}", e.getMessage());
            pool.shutdownNow();
        }
    }
}
