package school.faang.multithreading.asynchronism.carry.overfed;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Dota {
    private static final int THREADS_COUNT = 5;
    private static final ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);

    public static void main(String[] args) {
        CombineService service = new CombineService();
        Inventory inventory = new Inventory();

        service.getItemFrom("Chest", 100, executor)
                .thenCombine(service.getItemFrom("Shop", 100, executor), service::combineItems)
                .thenCompose(item -> CompletableFuture.runAsync(() -> inventory.addItem(item)))
                .thenRun(() -> log.info("Inventory: {}", inventory.getItems()))
                .thenRun(Dota::shutdown);

        awaitTermination();
    }

    private static void shutdown() {
        executor.shutdown();
    }

    private static void awaitTermination() {
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
