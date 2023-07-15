package faang.school.godbless.Sprint4Future.Alchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Potion health = new Potion("Increase Health", 10);
        Potion invisible = new Potion("Make invisible", 15);
        Potion power = new Potion("Increase Power", 15);

        List<Potion> potions = List.of(health, invisible, power);

        List<CompletableFuture<Integer>> completableFutures = potions.stream()
                .map(Potion::gatherIngredients).toList();
        CompletableFuture<Integer>[] futures = new CompletableFuture[completableFutures.size()];
        completableFutures.toArray(futures);

        CompletableFuture<Void> uCompletableFuture = CompletableFuture.allOf(futures);

        uCompletableFuture.thenRun(() -> {
            AtomicInteger result = new AtomicInteger(0);
            for (int i = 0; i < futures.length; i++) {
                try {
                    result.addAndGet(futures[i].get());
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(result.get());
        }).join();
    }
}
