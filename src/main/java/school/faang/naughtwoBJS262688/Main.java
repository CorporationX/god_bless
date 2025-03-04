package school.faang.naughtwoBJS262688;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion)))
                .toList();

        AtomicInteger totalIngredients = new AtomicInteger(0);
        futures.forEach(future -> future.thenAccept(totalIngredients::addAndGet));

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allOf.join();

        int result = totalIngredients.get();
        log.info("Total amount of ingredients collected: {}", result);
    }

    private static int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(RANDOM.nextInt(1000) + 500);
            return potion.requiredIngredients();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
