package school.faangSprint4.t05;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Зелье лечения", 5),
                new Potion("Зелье маны", 3),
                new Potion("Зелье выносливости", 4),
                new Potion("Зелье невидимости", 6)
        );
        log.info("Начинаем сбор ингредиентов для всех зелий...\n");
        gatherAllIngredients(potions);
    }

    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("Начинаем сбор ингредиентов для зелья: {}", potion.name());
                Thread.sleep((long) (Math.random() * 2000) + 1000);
                log.info("Завершён сбор ингредиентов для зелья: {} (собрано {} ингредиентов)", potion.name(), potion.requiredIngredients());
                return potion.requiredIngredients();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Ошибка при сборе ингредиентов", e);
            }
        });
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(PotionGathering::gatherIngredients)
                .toList();
        AtomicInteger totalIngredients = new AtomicInteger(0);
        CompletableFuture<Void> allOf = CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[0])
        );
        try {
            allOf.thenRun(() ->
                    futures.forEach(future ->
                            totalIngredients.addAndGet(future.join())
                    )
            ).join();
            log.info("\nОбщее количество собранных ингредиентов: {}", totalIngredients.get());
        } catch (Exception e) {
            log.error("Произошла ошибка при сборе ингредиентов: {}", e.getMessage());
        }
    }
}