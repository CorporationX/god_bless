package faang.school.godbless.mt.alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    private static final int THREAD_COUNT = 10;
    private static final long TIME_FOR_INGREDIENT = 1000;

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        AtomicInteger result = new AtomicInteger(0);
        List<CompletableFuture<Void>> futures = potions.stream()
                .map(p -> CompletableFuture
                        .supplyAsync(() -> collectIngredients(p), executor)
                        .thenAccept(i -> {
                            log.info("Collected ingredients = {}", i);
                            result.addAndGet(i);
                        })
                )
                .toList();


        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        log.info("Summary collected ingredients - {}", result.get());
        executor.shutdown();
    }

    private static Integer collectIngredients(Potion potion) {
        try {
            Thread.sleep(potion.getRequiredIngredients() * TIME_FOR_INGREDIENT);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return potion.getRequiredIngredients();
    }
}
