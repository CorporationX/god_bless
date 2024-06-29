package faang.school.godbless.multithreading_async.task_10;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        final Inventory inventory = new Inventory();
        final CompletableFuture<Item> itemFromChest = inventory.getItemFromChest();
        final CompletableFuture<Item> itemFromShop = inventory.getItemFromShop();
        itemFromChest
            .thenCombine(itemFromShop, inventory::combineItem)
            .thenCompose(item -> CompletableFuture.runAsync(() -> inventory.addItem(item)));
        inventory.shutdownExecutor();
    }
}
