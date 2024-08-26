package faang.school.godbless.BJS2_25073;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Potion potion1 = new Potion("flying potion", 5);
        Potion potion2 = new Potion("underwater breath potion", 3);
        Potion potion3 = new Potion("strength potion", 7);

        List<Potion> potions = List.of(potion1, potion2, potion3);

        AtomicInteger sum = new AtomicInteger(0);
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(
                potions.stream()
                        .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion))
                                .thenApply(sum::addAndGet))
                        .toArray(CompletableFuture[]::new));
        combinedFuture.join();
        System.out.println(sum);
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
