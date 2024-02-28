package faang.school.godbless.carryisoverfed3194;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AntiMage {
    static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        Inventory inventory = new Inventory(new ArrayList<>());
        CompletableFuture<Item> futureFirstItemAdded = inventory.addItem(Item.SKULL_BASHER, EXECUTOR);
        CompletableFuture<Item> futureSecondItemAdded = inventory.addItem(Item.BUTTERFLY, EXECUTOR);

        futureSecondItemAdded.thenRun(() -> System.out.println("Items added. Inventory: " + inventory.getItems()));
        futureFirstItemAdded.thenCombine(
                        futureSecondItemAdded, (item1, item2) -> inventory.combineItems(item1, item2, EXECUTOR))
                .thenCompose(item -> {
                    try {
                        return inventory.addItem(item.get(), EXECUTOR);
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                })
                .thenRun(() -> System.out.println("Items combined. Inventory: " + inventory.getItems()))
                .thenRun(EXECUTOR::shutdown);
    }
}
