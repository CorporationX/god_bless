package Multithreading.bc3286_Download_Alchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Application {
    public static void main(String[] args) {

        Potion potion1 = new Potion("Potion1", 5);
        Potion potion2 = new Potion("Potion2", 15);
        Potion potion3 = new Potion("Potion3", 10);
        Potion potion4 = new Potion("Potion4", 3);
        Potion potion5 = new Potion("Potion5", 20);

        List<Potion> potions = List.of(potion1, potion2, potion3, potion4, potion5);

        List<CompletableFuture<Integer>> completableFutures = potions.stream()
                .map(potion -> potion.gatherIngredients(potion))
                .toList();

        AtomicInteger sumOfIngredients = new AtomicInteger(0);
        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]))
                .thenRun(() ->
                        completableFutures.forEach(integerCompletableFuture -> sumOfIngredients
                                .addAndGet(integerCompletableFuture.join()))
                ).join();

        System.out.println(sumOfIngredients);
    }
}
