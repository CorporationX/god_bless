package faang.school.godbless.theElderScrolls;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Gathering ingredients for " + potion.getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return potion.getRequiredIngredients();
        });
    }

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 3),
                new Potion("Mana Potion", 5),
                new Potion("Strength Potion", 2)
        );

        AtomicInteger totalIngredients = new AtomicInteger();

        List<CompletableFuture<Void>> futures = potions.stream()
                .map(potion ->
                        gatherIngredients(potion)
                                .thenAccept(totalIngredients::addAndGet))
                .toList();

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        try {
            allOf.get();
            System.out.println("Total ingredients: " + totalIngredients.get());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Interrupted");
        }
    }
}
