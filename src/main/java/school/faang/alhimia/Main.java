package school.faang.alhimia;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    private static final Group group = new Group();
    private static final AtomicInteger totalIngredients = new AtomicInteger(0);
    private static final ExecutorService pool = Executors.newFixedThreadPool(6);

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Зелье1", 3),
                new Potion("Зелье2", 2),
                new Potion("Зелье3", 6),
                new Potion("Зелье4", 1),
                new Potion("Зелье5", 2),
                new Potion("Зелье6", 4)
        );

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> group.gatherIngredients(potion), pool))
                .toList();

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        log.info("Ждем завершения всех потоков");
        combinedFuture.join();
        log.info("Продолжаем операции в Main");

        terminatedExecutor(pool);

        futures.forEach(future -> future.thenApply(totalIngredients::addAndGet));
        log.info("Общее количество собранных ингредиентов: {}", totalIngredients.get());
    }

    public static void terminatedExecutor(ExecutorService pool) {
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