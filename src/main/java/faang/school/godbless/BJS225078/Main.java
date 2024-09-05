package faang.school.godbless.BJS225078;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
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
