package faang.school.godbless.fourth.DownloadAlchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Potion of life", 10),
                new Potion("Mana potion", 8),
                new Potion("Potion of energy", 12)
        );

        CompletableFuture<?>[] futures = new CompletableFuture<?>[potions.size()];

        for (int i = 0; i < potions.size(); i++) {
            int finalI = i;
            futures[i] = CompletableFuture.supplyAsync(() -> gatherIngredients(potions.get(finalI)));
        }

        CompletableFuture.allOf(futures)
                .thenApply(v -> {
                    AtomicInteger sum = new AtomicInteger(0);
                    for (CompletableFuture<?> future : futures) {
                        sum.addAndGet((int) future.join());
                    }
                    return sum.get();
                })
                .thenAccept(sum -> System.out.println("Total ingredients: " + sum))
                .join();
    }

    public static int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
            return -1;
        }
        return potion.requiredIngredients();
    }
}
