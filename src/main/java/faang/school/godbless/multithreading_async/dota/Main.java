package faang.school.godbless.multithreading_async.dota;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        CompletableFuture<Item> firstItemFuture = Inventory.getFirstItemFromChest();
        CompletableFuture<Item> secondItemFuture = Inventory.getSecondItemFromShop();
        firstItemFuture.thenCombine(secondItemFuture, inventory::combineItem)
                .thenCompose(item -> CompletableFuture.runAsync(() -> inventory.addItem(item))).join();
        System.out.println(inventory.getItems());

    }
}
