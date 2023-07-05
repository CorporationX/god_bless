package sprint5.tes;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class AlchemyTable {
    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger();
        List<Potion> potions = List.of(new Potion("Fugitive potion", 2), new Potion("Warrior Potion", 2),
                new Potion("Scuma", 3), new Potion("Water Walking Potion", 5));

        List<CompletableFuture<Void>> futures = potions.stream()
                .map(potion ->
                        CompletableFuture.runAsync(() -> integer.addAndGet(potion.gatherIngredients()))
                ).toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        System.out.println(integer.get());
    }
}
