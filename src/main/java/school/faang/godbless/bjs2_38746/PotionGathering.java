package school.faang.godbless.bjs2_38746;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class PotionGathering {
    private static int totalIngredients = 0;

    public static void main(String[] args) throws InterruptedException {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );
        GatheringService gatheringService = new GatheringService();
        ExecutorService pool = Executors.newCachedThreadPool();
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatheringService.gatherIngredients(potion), pool))
                .toList();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        futures.forEach(future -> future.thenAccept(PotionGathering::addToTotalIngredients));
        pool.shutdown();
        if (pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS)) {
            log.info("Total collected ingredients: {}", totalIngredients);
        } else {
            log.error("Failed to terminate the pool");
        }
    }

    private static synchronized void addToTotalIngredients(int ingredients) {
        totalIngredients += ingredients;
    }
}
