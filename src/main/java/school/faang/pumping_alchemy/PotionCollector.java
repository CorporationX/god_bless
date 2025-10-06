package school.faang.pumping_alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Проект: god_bless
 * Класс PotionCollector
 * Автор: Vital
 */

@Slf4j
public class PotionCollector {
    private static final int COLLECTION_TIME_MS = 1000;

    public CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("Сбор ингредиентов для зелья: {}", potion.getName());
                Thread.sleep(COLLECTION_TIME_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Ошибка при сборе ингредиентов для зелья {}", potion.getName(), e);
                throw new RuntimeException(e);
            }
            log.info("Собрано {} ингредиентов для зелья: {}", potion.getRequiredIngredients(), potion.getName());
            return potion.getRequiredIngredients();
        });
    }

    public void gatherAllIngredients(List<Potion> potions) {
        if (potions == null || potions.isEmpty()) {
            log.warn("Список зелий пустой, сбор ингредиентов не выполнен.");
            return;
        }

        AtomicInteger totalIngredients = new AtomicInteger(0);

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(this::gatherIngredients)
                .toList();

        CompletableFuture<Void> allDone = CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[0])
        );

        allDone.join();

        futures.forEach(future -> totalIngredients.addAndGet(future.join()));

        log.info("Общее количество собранных ингредиентов: {}", totalIngredients.get());
        System.out.println("Общее количество собранных ингредиентов: " + totalIngredients.get());
    }
}