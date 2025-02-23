package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    public static int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error("Sleep was interrupted.");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        log.info("All ingredients for {} have been collected.", potion.getName());
        return potion.getRequiredIngredients();
    }

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        AtomicInteger totalIngredients = new AtomicInteger(0);
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion))
                        .thenApply(totalIngredients::addAndGet))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        log.info("Total amount of collected ingredients: {}", totalIngredients.get());
    }
}
