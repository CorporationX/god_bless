package faang.school.godbless.pumpingAlchemy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) {
        List<Potion> potions = new ArrayList<>();
        potions.add(new Potion("1", 12));
        potions.add(new Potion("2", 2));
        potions.add(new Potion("3", 6));
        potions.add(new Potion("4", 4));
        potions.add(new Potion("5", 8));

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> potion.gatherIngredients(potion), executor))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()])).join();

        AtomicInteger result = new AtomicInteger(0);
        for (CompletableFuture<Integer> future : futures) {
            future.thenAccept(result::addAndGet);
        }
        System.out.println(result);
    }
}
