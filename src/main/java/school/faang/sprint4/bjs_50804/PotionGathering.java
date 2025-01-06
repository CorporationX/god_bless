package school.faang.sprint4.bjs_50804;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    private static final int TIME_SLEEP = 1000;

    public static void main(String[] args) {

        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 13),
                new Potion("Stamina Potion", 7)
        );

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(PotionGathering::gatherIngredients)
                .toList();

        AtomicInteger totalIngredients = new AtomicInteger(0);

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> futures.forEach(future -> totalIngredients.addAndGet(future.join())))
                .join();
        log.info("Total ingredients: {}", totalIngredients);
    }

    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("Collecting {}", potion.name());
                Thread.sleep(TIME_SLEEP);
            } catch (InterruptedException e) {
                log.error("Task was interrupted");
                Thread.currentThread().interrupt();
            }
            return potion.requiredIngredients();
        });
    }
}
