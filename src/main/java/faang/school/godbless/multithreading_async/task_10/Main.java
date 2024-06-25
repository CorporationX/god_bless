package faang.school.godbless.multithreading_async.task_10;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int THREAD_COUNT = 4;

    public static void main(String[] args) {
        final Inventory inventory = new Inventory();
        final ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        final CompletableFuture<Item> itemFromChest = inventory.getItemFromChest(executor);
        final CompletableFuture<Item> itemFromShop = inventory.getItemFromShop(executor);
        itemFromChest
                .thenCombine(itemFromShop, inventory::combineItem)
                .thenCompose(item -> CompletableFuture.runAsync(() -> inventory.addItem(item)));
        executor.shutdown();
    }
}
