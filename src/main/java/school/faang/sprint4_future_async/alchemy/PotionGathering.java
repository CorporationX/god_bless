package school.faang.sprint4_future_async.alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {

    private static final long FIX_RATE = 100L;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(2);

    static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<AtomicInteger>> futures = potions.stream()
                .map(PotionGathering::getPotion)
                .toList();

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allOf.thenRun(() -> {
            int totalIngredients = futures.stream()
                    .map(CompletableFuture::join)
                    .mapToInt(AtomicInteger::get)
                    .sum();

            System.out.printf("Общее количество собранных ингредиентов: %d%n", totalIngredients);
        }).exceptionally(ex -> {
            log.error("Ошибка при сборе ингредиентов", ex);
            return null;
        });
    }

    private static CompletableFuture<AtomicInteger> getPotion(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(FIX_RATE);
            } catch (InterruptedException e) {
                log.error("ОШIБКА прерывания во время выполнения сна!!!", e);
                Thread.currentThread().interrupt();
            }
            return new AtomicInteger(potion.getRequiredIngredients());
        }, EXECUTOR);
    }

    static void executorShutdown() {
        EXECUTOR.shutdown();
        try {
            if (!EXECUTOR.awaitTermination(2, TimeUnit.MINUTES)) {
                log.error("Задача не завершилась за 2 мин, принудительно останавливаем...");
                EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Главный поток был прерван во время ожидания, принудительно останавливаем пул...");
            EXECUTOR.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}