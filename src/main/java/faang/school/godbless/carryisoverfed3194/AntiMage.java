package faang.school.godbless.carryisoverfed3194;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AntiMage {
    static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();
    static final Inventory INVENTORY = new Inventory(new ArrayList<>());

    public static void main(String[] args) {
        CompletableFuture<Item> futureFirstItemAdded = INVENTORY.addItem(Item.SKULL_BASHER, EXECUTOR);
        CompletableFuture<Item> futureSecondItemAdded = INVENTORY.addItem(Item.BUTTERFLY, EXECUTOR);
        futureSecondItemAdded.thenRun(() -> System.out.println("Items added. Inventory: " + INVENTORY.getItems()));

        futureFirstItemAdded.thenCombine(
                        futureSecondItemAdded, (item1, item2) -> INVENTORY.combineItems(item1, item2, EXECUTOR))
                .thenCompose(item -> INVENTORY.addItem(getFutureItem(item), EXECUTOR))
                .thenRun(() -> System.out.println("Items combined. Inventory: " + INVENTORY.getItems()))
                .thenRun(EXECUTOR::shutdown);
    }

    private static Item getFutureItem(CompletableFuture<Item> futureItem) {
        try {
            return futureItem.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Current thread was interrupted", e);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            throw new RuntimeException("Error during async operation", cause);
        }
    }
}
