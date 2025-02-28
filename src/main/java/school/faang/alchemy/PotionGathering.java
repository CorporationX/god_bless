package school.faang.alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    private static final AtomicInteger ingredients = new AtomicInteger(0);
    private static final int TIMEOUT_ONE_SECOND = 1_000;
    private static final int TIMEOUT_TEN_SECOND = 10_000;
    private static final int THREADS_COUNTER = 4;
    private static final ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNTER);

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        PotionGathering.gatherAllIngredients(potions);
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT_TEN_SECOND, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                log.error("Pool did not terminate");
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
            Thread.currentThread().interrupt();
        }

    }

    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(TIMEOUT_ONE_SECOND);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error(e.getMessage(), e);
            }
            log.info("{} ingredients  collected {}", potion.getName(), potion.getRequiredIngredients());
            return ingredients.addAndGet(potion.getRequiredIngredients());

        }, executor);
    }

    private static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> allIngredients = potions.stream()
                .map(PotionGathering::gatherIngredients)
                .toList();
        CompletableFuture.allOf(allIngredients.toArray(new CompletableFuture[0])).join();
        log.info("{} ingredients collected", ingredients.get());

    }
}
