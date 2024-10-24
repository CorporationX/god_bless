package school.faang.fourthStream.BJS2_38796;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Combiner {
    private static final int SLEEP_TIME = 1000;

    public CompletableFuture<Item> combineItems(Item item1, Item item2, Inventory inventory) {
        return CompletableFuture.supplyAsync(() -> {
            Item combinedItem = inventory.combineItems(item1, item2);
            log.info("Скомбинированный предмет: {}", combinedItem.getName());
            return combinedItem;
        });
    }

    public CompletableFuture<Item> getItemFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new Item("Chest Item", 10);
        });
    }

    public CompletableFuture<Item> getItemFromShop() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new Item("Shop Item", 20);
        });
    }

    public CompletableFuture<Void> addItemToInventoryAsync(Item item, Inventory inventory) {
        return CompletableFuture.runAsync(() -> {
            inventory.addItem(item);
            log.info("Предмет добавлен в инвентарь: {}", item.getName());
        });
    }
}
