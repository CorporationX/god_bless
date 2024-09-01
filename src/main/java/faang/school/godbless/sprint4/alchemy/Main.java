package faang.school.godbless.sprint4.alchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        AtomicInteger totalIngredients = new AtomicInteger(0);
        List<CompletableFuture<Void>> futures = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> {
                    Potion potion = new Potion("Potion_" + i, i);
                    return collectPotionIngredients(potion, totalIngredients);
                })
                .toList();

        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();
        System.out.println("Total ingredients: " + totalIngredients.get());
    }

    public static CompletableFuture<Void> collectPotionIngredients(Potion potion, AtomicInteger totalIngredients) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                throw new RuntimeException("Thread interrupted!");
            }
            totalIngredients.addAndGet(potion.ingredients());
        });
    }
}
