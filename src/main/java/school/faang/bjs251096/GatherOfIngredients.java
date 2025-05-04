package school.faang.bjs251096;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class GatherOfIngredients {

    public int gatherIngredients(Potion potion) {
        try {
            log.info("Gathering ingredients for {}", potion.getName());
            Thread.sleep(2000); // Simulate ingredient gathering
        } catch (InterruptedException e) {
            log.error("Interrupted while gathering ingredients for {}", potion.getName(), e);
            Thread.currentThread().interrupt();
        }
        return potion.getRequiredIngredients();
    }

    public void gatherAllIngredients(List<Potion> potionList) {
        log.info("Starting to gather all ingredients for {} potions", potionList.size());
        List<CompletableFuture<Integer>> futures = potionList.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion)))
                .toList();

        CompletableFuture<Void> all = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        AtomicInteger totalIngredients = new AtomicInteger(0);
        futures.forEach(future -> {
            int ingredients = future.join();
            log.info("Gathered {} ingredients", ingredients);
            totalIngredients.addAndGet(ingredients);
        });
        log.info("Total ingredients gathered: {}", totalIngredients.get());
    }
}