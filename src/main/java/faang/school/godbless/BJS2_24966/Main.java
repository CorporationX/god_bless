package faang.school.godbless.BJS2_24966;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory(new ArrayList<>());
        CompletableFuture<Item> chestItem = inventory.getItemFromChest();
        CompletableFuture<Item> shopItem = inventory.getItemFromShop();

        shopItem.thenCombine(chestItem, inventory::combineItems)
                .thenCompose(item -> CompletableFuture.runAsync(() -> inventory.addItem(item)))
                .join();
    }
}
