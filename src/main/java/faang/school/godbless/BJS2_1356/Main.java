package faang.school.godbless.BJS2_1356;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Item item1 = new Item("item1", 2);
        Item item2 = new Item("item3", 2);
        inventory.addItem(item1);
        inventory.addItem(item2);

        CompletableFuture<Item> itemFromChestFuture = CompletableFuture.supplyAsync(Main::getItemFromChest);
        CompletableFuture<Item> itemFromShopFuture = CompletableFuture.supplyAsync(Main::getItemFromShop);

        CompletableFuture<Item> combineItemFuture = itemFromChestFuture
                .thenCombineAsync(itemFromShopFuture, inventory::combine);

        CompletableFuture<Void> addItemToInvFuture = combineItemFuture.thenComposeAsync(item
                -> CompletableFuture.runAsync(() -> inventory.addItem(item)));

        CompletableFuture.allOf(itemFromChestFuture, itemFromShopFuture, combineItemFuture, addItemToInvFuture).join();

        System.out.println(inventory);
    }

    private static Item getItemFromChest() {
        return new Item("Sword", ThreadLocalRandom.current().nextInt(1, 10));
    }

    private static Item getItemFromShop() {
        return new Item("Shield", ThreadLocalRandom.current().nextInt(1, 10));
    }
}