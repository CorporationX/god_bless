package school.faang.sprint4.task_50781;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Slf4j
public class PotionCollector {

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

    public int gatherAllIngredients(@NonNull List<Potion> potions) {
        if (potions.isEmpty()) {
            throw new IllegalArgumentException("The list of potions is empty");
        }

        ExecutorService pool = Executors.newCachedThreadPool();

        List<CompletableFuture<Integer>> collectFuture = potions.stream()
                .map((potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion), pool)))
                .toList();

        pool.shutdown();

        AtomicInteger result = new AtomicInteger(0);
        collectFuture.forEach((future) -> result.addAndGet(future.join()));

        try {
            pool.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            pool.shutdownNow();
            throw new RuntimeException(e);
        }

        return result.get();
    }
}
