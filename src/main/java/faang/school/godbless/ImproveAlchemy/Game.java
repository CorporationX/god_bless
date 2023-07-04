package faang.school.godbless.ImproveAlchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class Game {
    public static void main(String[] args) {
        Potion potion1 = new Potion("Resist Shock", 10);
        Potion potion2 = new Potion("Restore Health", 15);
        Potion potion3 = new Potion("Paralysis", 13);
        Potion potion4 = new Potion("Weakness to Shock", 20);
        Potion potion5 = new Potion("Waterbreathing", 8);
        List<Potion> potions = List.of(potion1, potion2, potion3, potion4, potion5);

        List<CompletableFuture<Integer>> potionsFutures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(potion::gatherIngredients))
                .toList();

        AtomicInteger total = new AtomicInteger(0);
        CompletableFuture.allOf(potionsFutures.toArray(new CompletableFuture[potionsFutures.size()]))
                .thenRun(() -> {
                            for (CompletableFuture<Integer> potion : potionsFutures) {
                                try {
                                    total.addAndGet(potion.get());
                                } catch (InterruptedException | ExecutionException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        })
                .join();

        System.out.println(total);
    }
}
