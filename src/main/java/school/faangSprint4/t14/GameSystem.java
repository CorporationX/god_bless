package school.faangSprint4.t14;

import lombok.Getter;

import java.util.concurrent.CompletableFuture;

@Getter
public class GameSystem {
    private static final int SLEEP_TIME = 1000;
    private static final int POWER = 10;
    private final Inventory inventory;

    public GameSystem() {
        this.inventory = new Inventory();
    }

    public CompletableFuture<Item> getItemFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Getting item from chest...");
                Thread.sleep(SLEEP_TIME);
                Item item = new Item("Sword", POWER);
                System.out.println("Got item from chest: " + item);
                return item;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public CompletableFuture<Item> getItemFromShop() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Getting item from shop...");
                Thread.sleep(SLEEP_TIME * 2L);
                Item item = new Item("Shield", POWER * 2);
                System.out.println("Got item from shop: " + item);
                return item;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public CompletableFuture<Item> combineItemsAsync(Item item1, Item item2) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Combining items...");
                Thread.sleep(SLEEP_TIME);
                Item combinedItem = inventory.combineItems(item1, item2);
                System.out.println("Created combined item: " + combinedItem);
                return combinedItem;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public CompletableFuture<Void> addItemToInventoryAsync(Item item) {
        return CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Adding item to inventory...");
                Thread.sleep(SLEEP_TIME / 2);
                inventory.addItem(item);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}