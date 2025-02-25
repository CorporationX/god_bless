package school.faang.levelingupalchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j

public record Potion(String name, int requiredIngredients) {
    public static int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("Произошла ошибка при ожидаенние... {}", e.getMessage());
            Thread.currentThread().interrupt();
        }

        return potion.requiredIngredients();
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> CompletableFuture
                        .supplyAsync(() -> gatherIngredients(potion))).toList();


        AtomicInteger totalIngredients = new AtomicInteger(0);
        futures.forEach((future -> future.thenApply(totalIngredients::addAndGet)));

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        log.info("Общее количество собраных ингредиентов {}", totalIngredients.get());
    }
}