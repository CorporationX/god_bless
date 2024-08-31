package faang.school.godbless.BJS2_25073;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(new Potion("flying potion", 5),
                new Potion("underwater breath potion", 3),
                new Potion("strength potion", 7)
        );

        AtomicInteger sumIngredients = new AtomicInteger(0);
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(
                potions.stream()
                        .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion))
                                .thenApply(sumIngredients::addAndGet))
                        .toArray(CompletableFuture[]::new));
        combinedFuture.join();
        System.out.println(sumIngredients);
    }

    public static int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(1000L * potion.getRequiredIngredients());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        return potion.getRequiredIngredients();
    }
}
