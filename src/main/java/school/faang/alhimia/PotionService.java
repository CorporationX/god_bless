package school.faang.alhimia;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionService {
    private static final int COUNT_THREAD = 6;
    private static final ExecutorService pool = Executors.newFixedThreadPool(COUNT_THREAD);
    private static final AtomicInteger totalIngredients = new AtomicInteger();

    private int gatherIngredients(Potion potion) {
        int countIngredients = potion.getRequiredIngredients();
        simulationGetIngredient(countIngredients);
        log.info("для зелья {} необходимо {} ингредиентов", potion.getName(), countIngredients);
        return countIngredients;
    }

    private void simulationGetIngredient(int countIngredients) {
        try {
            TimeUnit.SECONDS.sleep(countIngredients);
            log.info("имитация сбора средств для зелья");
        } catch (InterruptedException e) {
            log.info("Поток прерван");
            Thread.currentThread().interrupt();
        }
    }

    public void fetchIngredientsAsync(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> CompletableFuture
                        .supplyAsync(() -> gatherIngredients(potion), pool)
                        .thenApply(totalIngredients::addAndGet))
                .toList();

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        log.info("Ждем завершения всех потоков");
        combinedFuture.join();
        log.info("Продолжаем операции в Main");

        terminatedExecutor();
    }

    public void printTotalIngredients() {
        log.info("Общее количество собранных ингредиентов: {}", totalIngredients.get());
    }

    private void terminatedExecutor() {
        pool.shutdown();
        try {
            if (!pool.awaitTermination(5, TimeUnit.SECONDS)) {
                pool.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.info("Поток прерван");
            pool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
