package pumpingalchemy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@AllArgsConstructor
public class Potion {
    private String name;
    private int requiredIngredients;

    public static int gatherIngredients(List<Potion> potions) {
        AtomicInteger totalIngredients = new AtomicInteger();

        List<CompletableFuture<Void>> futures = potions.stream()
                .map(potion -> CompletableFuture.runAsync(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new IllegalArgumentException("Ошибка при вызове метода sleep().");
                    }
                    totalIngredients.addAndGet(potion.getRequiredIngredients());
                }))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        return totalIngredients.get();
    }
}