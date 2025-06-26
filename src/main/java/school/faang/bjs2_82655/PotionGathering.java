package school.faang.bjs2_82655;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
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
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(PotionGathering::gatherIngredients)
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        AtomicInteger totalIngredients = new AtomicInteger(0);

        futures.forEach(future -> future.thenApply(totalIngredients::addAndGet));

        log.info("Общее количество собранных ингредиентов: {}", totalIngredients.get());
    }

    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("Сбор ингредиентов для зелья: {}", potion.getName());

            try {
                TimeUnit.SECONDS.sleep(potion.getRequiredIngredients());
            } catch (InterruptedException e) {
                log.error("Thread interrupted", e);
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }

            return potion.getRequiredIngredients();
        });
    }
}
