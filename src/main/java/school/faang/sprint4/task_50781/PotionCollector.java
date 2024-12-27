package school.faang.sprint4.task_50781;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Slf4j
public class PotionCollector {

    private final ExecutorService pool = Executors.newCachedThreadPool();

    public int gatherAllIngredients(@NonNull List<Potion> potions) {
        if (potions.isEmpty()) {
            throw new IllegalArgumentException("The list of potions is empty");
        }

        AtomicInteger result = new AtomicInteger(0);

        List<CompletableFuture<Void>> future = potions.stream()
                .map((potion) -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion))
                        .thenAccept(result::addAndGet))
                .toList();

        CompletableFuture<Void> resultFuture = CompletableFuture.allOf(future.toArray(new CompletableFuture[0]));
        resultFuture.join();

        shutdownPool();

        return result.get();
    }

    public void shutdownPool() {
        pool.shutdown();
        try {
            if (!pool.awaitTermination(30, TimeUnit.SECONDS)) {
                pool.shutdownNow();
            }
        } catch (InterruptedException e) {
            pool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    private int gatherIngredients(@NonNull Potion potion) {
        int ingredientsNumber = potion.getRequiredIngredients();

        IntStream.range(0, ingredientsNumber)
                .forEach((i) -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
        log.info("Collected " + ingredientsNumber + " for " + potion.getName());
        return ingredientsNumber;
    }
}
