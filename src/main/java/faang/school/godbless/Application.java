package faang.school.godbless;

import faang.school.godbless.model.Inventory;
import faang.school.godbless.model.Item;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class Application {

    private static Item takeStoreItem() throws InterruptedException {
        Thread.sleep(2_000);
        return new Item("store_item", 21);
    }

    private static Item takeChestItem() throws InterruptedException {
        Thread.sleep(4_000);
        return new Item("chest_item", 35);
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory(new ArrayList<>());

        CompletableFuture<Item> chestLootingFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return takeChestItem();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture<Item> shoppingStoreFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return takeStoreItem();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        chestLootingFuture.thenCombine(shoppingStoreFuture,
                inventory::combineItem).thenAccept(inventory::addItem).join();

        inventory.items().forEach(System.out::println);
    }
}