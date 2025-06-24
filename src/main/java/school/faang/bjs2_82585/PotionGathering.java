package school.faang.bjs2_82585;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    private static final long POOL_AWAIT_TIMEOUT = 20;
    private static ExecutorService fixedPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion), fixedPool))
                .toList();

        AtomicInteger totalIngredients = new AtomicInteger(0);
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenAccept(param -> futures.forEach(future -> totalIngredients.addAndGet(future.join()))).join();


        fixedPool.shutdown();
        try {
            while (!fixedPool.awaitTermination(POOL_AWAIT_TIMEOUT, TimeUnit.SECONDS)) {
                log.info("Еще не все игридиенты собраны");
                fixedPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Поток был прерван", e);
            Thread.currentThread().interrupt();
            fixedPool.shutdownNow();
        }

        log.info("Всего собрано ингредиентов: {}", totalIngredients.get());
    }

    private static int gatherIngredients(Potion potion) {
        try {
            log.info("Начат сбор ингредиентов для зелья '{}'", potion.name());
            Thread.sleep(1000 * potion.ingredientCount());
            log.info("Завершен сбор ингредиентов для зелья '{}'", potion.name());

            return potion.ingredientCount();

        } catch (InterruptedException e) {
            log.error("Поток был прерван", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException("Поток был прерван", e);
        }
    }
}
