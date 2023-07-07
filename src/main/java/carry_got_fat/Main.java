package carry_got_fat;

import java.util.concurrent.CompletableFuture;


public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        CompletableFuture<Item> chestFuture = inventory.openChest();
        CompletableFuture<Item> shopFuture = inventory.buyItem();

        CompletableFuture<Void> combinedFuture = chestFuture.thenCombine(shopFuture, (item1, item2) -> {
            Item combinedItem = inventory.combineItems(item1, item2);
            return inventory.addToInventory(combinedItem);
        }).join();

        inventory.showInventory();
    }
}
