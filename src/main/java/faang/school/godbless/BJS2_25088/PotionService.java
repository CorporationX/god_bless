package faang.school.godbless.BJS2_25088;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionService {

    private static final List<Potion> potions = new ArrayList<>();
    private static final int THREAD_POOL_SIZE = 5;
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    private static final AtomicInteger totalIngredients = new AtomicInteger(0);

    public static void main(String[] args) {
        potions.addAll(List.of(new Potion("Amortentia", 6),
                new Potion("Death potion", 8),
                new Potion("Anti-Paralysis Potion", 3),
                new Potion("Felix Felicis", 12),
                new Potion("Memory Potion", 4)));

        CompletableFuture[] futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion), EXECUTOR_SERVICE)
                        .thenApply(ingredient -> totalIngredients.accumulateAndGet(ingredient, Integer::sum)))
                .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(futures).join();
        
        EXECUTOR_SERVICE.shutdown();

        System.out.println("Total " + totalIngredients + " potions");
    }

    public static int gatherIngredients(Potion potion) {

        System.out.println("Gathering ingredients for " + potion.getName());

        try {
            TimeUnit.SECONDS.sleep(potion.getRequiredIngredients());
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }

        System.out.println("Ingredients for " + potion.getName() + " are gathered");

        return potion.getRequiredIngredients();
    }
}
