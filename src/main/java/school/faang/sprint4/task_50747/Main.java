package school.faang.sprint4.task_50747;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        CompletableFuture<Item> chestItem = inventory.getItemFromChest();
        CompletableFuture<Item> shopItem = inventory.getItemFromShop();

        CompletableFuture<Void> item = inventory.combineTwoItems(chestItem, shopItem);
        item.join();
        inventory.printInventory();
    }
}
