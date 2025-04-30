package alchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class PotionGathering {

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(Potion::gatherIngredients)
                .toList();

        AtomicInteger total = new AtomicInteger();
        futures.forEach(future -> future.thenApply(total::addAndGet));

        futures.forEach(CompletableFuture::join);

        System.out.println("Total ingredients gathered: " + total.get());
    }
}
