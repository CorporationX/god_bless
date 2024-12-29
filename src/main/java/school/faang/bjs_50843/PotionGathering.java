package school.faang.bjs_50843;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    private static final long GATHERING_DURATION = 100;
    private final ExecutorService executor = Executors.newFixedThreadPool(1000);

    public int gatherAllIngredients(List<Potion> potions) {
        AtomicInteger sum = new AtomicInteger(0);
        List<CompletableFuture<Void>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion), executor)
                        .thenAcceptAsync(sum::addAndGet))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .join();
        log.info("Finished numbers futures: {}", futures.size());
        log.info("Gathering all ingredients");

        return sum.get();
    }

    private int gatherIngredients(Potion potion) {
        log.info("Gathering ingredients for {} start", potion.getName());

        try {
            Thread.sleep(potion.getRequiredIngredients() * GATHERING_DURATION);
        } catch (InterruptedException e) {
            log.error("Gathering ingredients for {} interrupted", potion.getName());
        }

        log.info("Gathering ingredients for {} finish", potion.getName());
        return potion.getRequiredIngredients();
    }
}
