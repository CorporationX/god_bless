package school.faang.godbless.bjs2_38746;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        futures.forEach(future -> future.thenAccept(PotionGathering::addToTotalIngredients));
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        pool.shutdown();
        log.info("Total collected ingredients: {}", totalIngredients);
    }

    private static synchronized void addToTotalIngredients(int ingredients) {
        totalIngredients += ingredients;
    }
}
