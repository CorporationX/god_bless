package faang.school.godbless.BJS2_25009;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    private static final int EXECUTION_MULTIPLIER = 1000;

    public static void main(String[] args) {
        AtomicInteger sumOfIgredients = new AtomicInteger(0);
        List<Potion> potions = List.of(new Potion("inivsible", 6),
                new Potion("strength", 3),
                new Potion("speed", 4),
                new Potion("levitation", 8));

        CompletableFuture<Void> futures = CompletableFuture.allOf(
                potions
                        .stream()
                        .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion))
                                .thenApply(sumOfIgredients::addAndGet))
                        .toArray(CompletableFuture[]::new));

        futures.join();
        System.out.println(sumOfIgredients);
    }

    public static int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(potion.requiredIngredients() * EXECUTION_MULTIPLIER);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Error in thread: {}", e.getMessage());
        }
        return potion.requiredIngredients();
    }
}
