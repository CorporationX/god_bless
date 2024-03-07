package faang.school.godbless.r_edzie.async.alchemy;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        AtomicInteger totalIngredients = new AtomicInteger(0);

        List<Potion> potions = Arrays.asList(
                new Potion("1", 10),
                new Potion("2", 12),
                new Potion("3", 3)
        );

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion)))
                .toList();

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allFutures.thenRun(() ->
                futures.forEach(future -> totalIngredients.addAndGet(future.join()))
        ).join();

        System.out.println(totalIngredients.get());
    }

    public static int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return potion.getRequiredIngredients();
    }
}
