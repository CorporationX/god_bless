package school.faang.godbless.bjs2_38810;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        try (InventoryManager inventoryManager = new InventoryManager()) {
            CompletableFuture<Item> item1 = inventoryManager.getFromChest();
            CompletableFuture<Item> item2 = inventoryManager.getFromShop();
            CompletableFuture<Item> combinedItem = inventoryManager.combineItems(item1, item2);
            inventoryManager.addToInventory(combinedItem);
        }
    }
}
