package school.faang.sprint_4.task_50690;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {

    public static final int DELAY = 1000;

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        putItemToInventory(inventory).join();

    }

    private static CompletableFuture<Item> getItemFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                log.error("Поток прерван во время ожидания");
                Thread.currentThread().interrupt();
            }
            Item item = new Item("Chest Item", 50);
            log.info("Получен предмет {} из Магазина", item.name());
            return item;
        });
    }

    private static CompletableFuture<Item> getItemFromShop() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                log.error("Поток прерван во время ожидания");
                Thread.currentThread().interrupt();
            }
            Item item = new Item("Shop Item", 100);
            log.info("Получен предмет {} из Магазина", item.name());
            return item;
        });
    }

    private static CompletableFuture<Item> getCombinedItem() {
        CompletableFuture<Item> futureChestItem = getItemFromChest();
        CompletableFuture<Item> futureShopItem = getItemFromShop();

        return futureChestItem.thenCombine(futureShopItem, (item1, item2) -> {
            Item combinedItem = Inventory.combineItem(item1, item2);
            log.info("Предмет скомбинирована в {}", combinedItem.name());
            return combinedItem;
        });
    }

    private static CompletableFuture<Void> putItemToInventory(Inventory inventory) {
        CompletableFuture<Item> futureCombinedItem = getCombinedItem();

        return futureCombinedItem.thenCompose(item -> {
            log.info("{} помещен в инвентарь", item.name());
            return CompletableFuture.runAsync(() -> inventory.addItem(item));
        });

    }
}
