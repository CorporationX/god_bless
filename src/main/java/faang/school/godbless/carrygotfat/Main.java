package faang.school.godbless.carrygotfat;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Dota2Game game = new Dota2Game();
        Inventory inventory = new Inventory();

        CompletableFuture<Item> chestItemFuture = game.getItemFromChest();
        CompletableFuture<Item> shopItemFuture = game.getItemFromShop();
        CompletableFuture<Item> combinedItemFuture = chestItemFuture.thenCombine(shopItemFuture, inventory::combineItems);

        combinedItemFuture.thenCompose(combinedItem ->
                CompletableFuture.runAsync(() -> inventory.addItem(combinedItem))
        ).join();
        System.out.println(inventory.getItems());
    }
}