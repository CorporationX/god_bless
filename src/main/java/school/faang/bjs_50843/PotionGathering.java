package school.faang.bjs_50843;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class PotionGathering {
    private static final long GATHERING_DURATION = 100;
    private final ExecutorService executor = Executors.newFixedThreadPool(1000);

    public int gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion), executor))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .join();

        log.info("Finished numbers futures: {}", futures.stream()
                .filter(CompletableFuture::isDone)
                .count());

        int sum;
        synchronized (potions) {
            log.info("Gathering all ingredients");
            sum = futures.stream()
                    .map(CompletableFuture::join)
                    .reduce(0, Integer::sum);
        }

        return sum;
    }

    private int gatherIngredients(Potion potion) {
        log.info("Gathering ingredients for {} start", potion.getName());

        try {
            Thread.sleep(potion.getRequiredIngredients() * GATHERING_DURATION);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        log.info("Gathering ingredients for {} finish", potion.getName());
        return potion.getRequiredIngredients();
    }
}
