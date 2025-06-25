package school.faang.module1.bjs2_82609;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class PotionGathering {

    private static final int GATHERING_SIMULATION_DELAY_MS = 1000;
    private static final int AWAIT_TERMINATION_TIMEOUT_SEC = 5;
    private static final int POOL_SIZE = 4;
    private static final ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(
                        () -> gatherIngredients(potion), executor))
                .toList();

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allFutures.join();

        int total = futures.stream()
                .mapToInt(CompletableFuture::join)
                .sum();

        log.info("Количество собранных ингредиентов: {}", total);

        executor.shutdown();

        try {
            if (!executor.awaitTermination(AWAIT_TERMINATION_TIMEOUT_SEC, TimeUnit.SECONDS)) {
                log.warn("Не все задачи успели завершиться. Принудительная остановка");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток был прерван", e);
            executor.shutdownNow();
            throw new RuntimeException(e);
        }
    }

    private static int gatherIngredients(Potion potion) {
        try {
            log.info("Начинаем сбор ингредиентов для зелья {}", potion.getName());
            Thread.sleep(GATHERING_SIMULATION_DELAY_MS);
            log.info("ингредиенты для зелья {} собраны", potion.getName());
            return potion.getRequiredIngredients();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток был прерван", e);
            throw new RuntimeException(e);
        }
    }
}