package BJS2_25108_Alchemy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Slf4j
@AllArgsConstructor
public class Potion {
    private final static int NUMBER_OF_THREADS = 4;
    private final String name;
    private int requiredIngredients;

    public int gatherIngredients(Potion potion) {
        AtomicInteger totalIngredients = new AtomicInteger(requiredIngredients);
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        CompletableFuture.allOf(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                log.error("Thread was interrupted!", e);
                Thread.currentThread().interrupt();
            }
            totalIngredients.addAndGet(potion.getRequiredIngredients());
            return totalIngredients.get();
        }, executor).whenComplete((result, throwable) -> executor.shutdown()));
        return totalIngredients.get();
    }
}
