package school.faang;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        CompletableFuture<Item> fromChest = inventory.getItemFromChest();
        CompletableFuture<Item> fromShop = inventory.getItemFromShop();
        fromShop.thenCombine(fromChest, inventory::combineItems)
                .thenCompose(item -> CompletableFuture.runAsync(() -> inventory.addItem(item)));
    }
}
