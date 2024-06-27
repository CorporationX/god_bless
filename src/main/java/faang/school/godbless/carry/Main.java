package faang.school.godbless.carry;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Chest chest = new Chest();
        Shop shop = new Shop();

        Inventory inventory = new Inventory();

        CompletableFuture<Item> itemFromChest = inventory.getFromChest(chest);
        CompletableFuture<Item> itemFromShop = inventory.getFromShop(shop);

        itemFromChest.thenCombine(itemFromShop, inventory::combineItems)
                .thenCompose(item -> CompletableFuture.runAsync(() -> inventory.addItem(item)));
    }
}
