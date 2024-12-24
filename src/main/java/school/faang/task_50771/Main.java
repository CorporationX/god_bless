package school.faang.task_50771;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        // Асинхронный сбор ингредиентов
        gatherAllIngredients(potions);
    }

    private static void gatherAllIngredients(List<Potion> potions) {
        AtomicInteger count = new AtomicInteger();
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion ->
                        CompletableFuture.supplyAsync(() -> {
                            try {
                                Thread.sleep((long) (Math.random() * 1000 * potion.requiredIngredients()));
                            } catch (InterruptedException e) {
                                log.error("Ошибка выполнения задачи: {}", e.getMessage());
                                Thread.currentThread().interrupt();
                            }

                            return potion.requiredIngredients();
                        })
                )
                .toList();

        futures.forEach(f -> {
            count.addAndGet(f.join());
        });

        log.info("Количество собранных ингредиентов: {}", count.get());
    }
}
