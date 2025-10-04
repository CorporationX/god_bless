package school.faang.bjs2_92960;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {


    public static void main(String[] args) {
        final ExecutorService ex = Executors.newFixedThreadPool(3);
        final List<Potion> potions = List.of(new Potion("Healing salve", 2),
                new Potion("Bismuth flask", 5),
                new Potion("Quicksilver flask", 3));

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> {
                    try {
                        return potion.gatherIngredient(potion);
                    } catch (InterruptedException e) {
                        log.error("Interrupted while gathering ingredients for {}: {}", potion.getName(),
                                e.getMessage());
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    }
                }, ex)).toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        AtomicInteger allIngredients = new AtomicInteger();
        futures.forEach(future -> {
            try {
                allIngredients.addAndGet(future.get());
                log.info("Collected ingredients: {}", future.get());
            } catch (Exception e) {
                log.error("Error collecting ingredients: {}", e.getMessage());
                Thread.currentThread().interrupt();
            }
        });

        log.info("Total ingredients gathering: {}", allIngredients);

        ex.shutdown();
        try {
            if (!ex.awaitTermination(15, TimeUnit.SECONDS)) {
                ex.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error(e.getMessage());
        }
    }
}
