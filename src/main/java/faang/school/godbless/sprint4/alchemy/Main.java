package faang.school.godbless.sprint4.alchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<CompletableFuture<Integer>> futures = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> {
                    Potion potion = new Potion("Potion_" + i, i);
                    return collectPotionIngredients(potion);
                })
                .toList();

        AtomicInteger totalIngredients = new AtomicInteger(0);
        CompletableFuture<Void> allComplete = CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));

        allComplete
                .thenRun(
                        () -> futures.forEach(f -> totalIngredients.addAndGet(f.join()))
                )
                .join();
        System.out.println("Total ingredients: " + totalIngredients.get());
    }

    public static CompletableFuture<Integer> collectPotionIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                throw new RuntimeException("Thread interrupted!");
            }
            return potion.ingredients();
        });
    }
}
