package school.faang.bjs2_74804;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Main {
    private static final int NUM_THREADS = 4;
    private static final int MAX_EXPECTATION = 60;

    public static void main(String[] args) {
        ExecutorService poolThreads = Executors.newFixedThreadPool(NUM_THREADS);
        Inventory inventory = new Inventory(poolThreads);
        CompletableFuture<Item> addedItem = inventory.getItemFromChest()
                .thenCombine(inventory.getItemFromStore(), inventory::combineItems)
                .thenCompose(inventory::addItem);

        addedItem.join();

        gracefullyShutdown(poolThreads);
    }

    private static void gracefullyShutdown(ExecutorService pool) {
        pool.shutdown();
        try {
            boolean isClose = pool.awaitTermination(MAX_EXPECTATION, SECONDS);
            if (!isClose) {
                pool.shutdownNow();
            }
        } catch (InterruptedException ex) {
            pool.shutdownNow();
            throw new ThreadStoppedException(ex);
        }
    }
}
