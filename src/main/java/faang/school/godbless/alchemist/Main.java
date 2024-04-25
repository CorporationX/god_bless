package faang.school.godbless.alchemist;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {

    private static final AtomicInteger INGREDIENTS_COUNT = new AtomicInteger();

    public static void main(String[] args) {
        List<Potion> allPotions = initialize();

        List<CompletableFuture<Integer>> futureList = allPotions.stream()
                .map(Main::gatherIngredients)
                .toList();

        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[]{}))
                .thenRun(() -> futureList.stream()
                        .map(CompletableFuture::join)
                        .forEach(INGREDIENTS_COUNT::getAndAdd))
                .thenRun(() -> System.out.println(INGREDIENTS_COUNT))
                .join();
    }

    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
            return potion.getRequiredIngredients();
        });
    }

    private static List<Potion> initialize() {
        return List.of(
                new Potion("Health potion", 3),
                new Potion("Damage potion", 4),
                new Potion("Invisibility potion", 2),
                new Potion("Speed potion", 5)
        );
    }
}
