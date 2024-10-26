package school.faang.carrygotfuckedup;

import java.util.concurrent.CompletableFuture;

public class DotaItemCombinationSystem {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        ItemService itemService = new ItemService();

        CompletableFuture<Item> chestItemFuture = itemService.getItemFromChest("Dragon Claw");
        CompletableFuture<Item> shopItemFuture = itemService.getItemFromShop("Phoenix Feather");

        CompletableFuture<Item> combinedItemFuture = chestItemFuture.thenCombine(shopItemFuture, inventory::combineItems);

        combinedItemFuture.thenCompose(combinedItem -> CompletableFuture.runAsync(() -> inventory.addItem(combinedItem)))
                .thenRun(inventory::printInventory)
                .join();
    }
}
