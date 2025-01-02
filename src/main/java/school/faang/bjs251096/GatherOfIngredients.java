package school.faang.bjs251096;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class GatherOfIngredients {

    public CompletableFuture<Integer> gatherIngredients(Potion potions) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("Gathering ingredients for {}", potions.getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                log.error("Interrupted while gathering ingredients for {}", potions.getName(), e);
                Thread.currentThread().interrupt();
            }
            return potions.getRequiredIngredients();
        });
    }

    public void gatherAllIngredients(List<Potion> potionList) {
        log.info("Starting to gather all ingredients for {} potions", potionList.size());
        List<CompletableFuture<Integer>> futures = potionList.stream()
                .map(this::gatherIngredients)
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
