package alchemy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Getter
@Slf4j
public class Potion {
    private String name;
    private int requiredIngredients;

    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                log.error("an error occurred while gathering ingredients for potion: {}", e.getMessage());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            return potion.getRequiredIngredients();
        });
        return future;
    }
}
