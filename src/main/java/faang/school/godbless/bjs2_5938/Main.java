package faang.school.godbless.bjs2_5938;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        CompletableFuture<Item> fromChest = inventory.getItemFromChest();
        CompletableFuture<Item> fromShop = inventory.buyItemFromShop();

        fromChest.thenCombine(fromShop, inventory::combineItems)
                .thenCompose(item -> CompletableFuture.runAsync(() -> inventory.addItem(item))).join();

        inventory.printInventory();
    }
}
