package school.faang.multithreading.asynchronism.pump.up.alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        gatherAllIngredients(potions);
    }

    private static void gatherAllIngredients(List<Potion> potions) {
        ExecutorService executor = Executors.newFixedThreadPool(potions.size());
        List<CompletableFuture<Integer>> waitingForResult = new ArrayList<>();

        potions.forEach(
                potion ->
                {
                    log.info("Начинаем собирать ингредиенты для: {} количество: {}", potion.getName(), potion.getRequiredIngredients());
                    CompletableFuture<Integer> requiredIngredients = CompletableFuture.supplyAsync(() -> {
                        try {
                            Thread.sleep(potion.getRequiredIngredients() * 1000L);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        log.info("Ингредиенты для: {} собраны", potion.getName());
                        return potion.getRequiredIngredients();
                    }, executor);
                    waitingForResult.add(requiredIngredients);
                });

        CompletableFuture.allOf(waitingForResult.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    AtomicInteger totalRequiredIngredients = new AtomicInteger(0);
                    waitingForResult.forEach(future -> {
                        totalRequiredIngredients.getAndAdd(future.join());
                    });
                    log.info("Общее количество собранных ингредиентов: {}", totalRequiredIngredients);
                });

        executor.shutdown();
        try {
            if (!executor.awaitTermination(2, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
