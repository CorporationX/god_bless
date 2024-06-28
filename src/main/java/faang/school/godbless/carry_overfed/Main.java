package faang.school.godbless.carry_overfed;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREADS = 4;
    private static final int TOTAL_COMBINES = 10;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
        Inventory inventory = new Inventory();


        for (int i = 0; i < TOTAL_COMBINES; i++) {
            inventory.getFromChest(executorService)
                    .thenCombine(inventory.getFromShop(executorService), inventory::combineItems)
                    .thenCompose(item -> CompletableFuture.runAsync(() -> inventory.addItem(item)))
                    .thenRun(() -> System.out.println("Success"));
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
            System.out.println(inventory.getItems());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
