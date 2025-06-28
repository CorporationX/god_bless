package school.faang.module4.alchemy;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    private static final long GATHERING_TIME_IN_MS = 2_000L;
    private static final long TERMINATION_TIME_IN_S = 5L;

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        // Асинхронный сбор ингредиентов
        gatherAllIngredients(potions);
    }

    public static void gatherAllIngredients(@NonNull List<Potion> potions) {
        if (potions.isEmpty()) {
            throw new IllegalArgumentException("potion is empty");
        }
        ExecutorService executor = Executors.newCachedThreadPool();
        AtomicInteger potionsIngredients = new AtomicInteger();
        for (Potion potion : potions) {
            CompletableFuture.supplyAsync(() -> gatherIngredients(potion), executor)
                    .thenAccept(ingredients -> potionsIngredients.addAndGet(ingredients));
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TERMINATION_TIME_IN_S, TimeUnit.SECONDS)) {
                log.warn("not all potions gathered. start force termination");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
            throw new RuntimeException(e);
        }

        log.info("All ingredients count: {}", potionsIngredients.get());
    }

    public static int gatherIngredients(@NonNull Potion potion) {
        try {
            Thread.sleep(GATHERING_TIME_IN_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        return potion.getRequiredIngredients();
    }
}
