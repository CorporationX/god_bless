package faang.school.godbless.fourthsprint.carry;

import java.util.concurrent.CompletableFuture;

public class Dota2InventorySystem {

    public static CompletableFuture<Item> getItemFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            simulateDelay();
            return new Item("Sword", 10);
        });
    }

    public static CompletableFuture<Item> getItemFromShop() {
        return CompletableFuture.supplyAsync(() -> {
            simulateDelay();
            return new Item("Shield", 15);
        });
    }

    private static void simulateDelay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static CompletableFuture<Item> combineItemsAsync(Inventory inventory, Item item1, Item item2) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Combining " + item1.getName() + " and " + item2.getName());
            return inventory.combineItems(item1, item2);
        });
    }

    public static CompletableFuture<Void> addToInventoryAsync(Inventory inventory, Item item) {
        return CompletableFuture.runAsync(() -> inventory.addItem(item));
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        CompletableFuture<Item> chestItemFuture = getItemFromChest();
        CompletableFuture<Item> shopItemFuture = getItemFromShop();

        chestItemFuture
                .thenCombine(shopItemFuture, (item1, item2) -> combineItemsAsync(inventory, item1, item2))
                .thenCompose(combinedItemFuture -> combinedItemFuture
                        .thenCompose(combinedItem -> addToInventoryAsync(inventory, combinedItem)))
                .join();

        System.out.println("Final inventory: " + inventory.getItems());
    }
}