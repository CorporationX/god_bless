package school.faang.task_50812;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

public class Main {

    private static final int DELAY = 1000;
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        //берем предмет из сундука
        CompletableFuture<Item> chestFutureItem = CompletableFuture.supplyAsync(() -> {
            logger.info("Retrieving item from chest...");
            simulateDelay(DELAY);
            return new Item("Shield", 15);
        }).exceptionally(e -> {
            logger.error("Error retrieving chest item: {}", e.getMessage(), e);
            return new Item("FallbackShield", 5);
        });

        //берем предмет из магазина
        CompletableFuture<Item> storeFutureItem = CompletableFuture.supplyAsync(() -> {
            logger.info("Retrieving item from store...");
            simulateDelay(DELAY);
            return new Item("Sword", 10);
        }).exceptionally(e -> {
            logger.error("Error retrieving store item: {}", e.getMessage(), e);
            return new Item("FallbackSword", 5);
        });

        //комбинируем
        CompletableFuture<Item> combinedItemFuture = chestFutureItem
                .thenCombine(storeFutureItem, (item1, item2) -> {
                    logger.info("Combining items: {} + {}", item1.name(), item2.name());
                    return inventory.combineItems(item1, item2);
                });

        //добавляем в инвентарь
        CompletableFuture<Void> addToInventoryFuture = combinedItemFuture.thenCompose(combinedItem ->
                CompletableFuture.runAsync(() -> {
                    inventory.addItem(combinedItem);
                    logger.info("Added combined item to inventory: {}", combinedItem.name());
                })
        );

        try {
            addToInventoryFuture.get();
            logger.info("Final inventory: {}", inventory.getItems());
        } catch (Exception e) {
            logger.error("Error during CompletableFuture execution", e);
        }
    }

    private static void simulateDelay(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("SimulateDelay method was interrupted", e);
            throw new RuntimeException("SimulateDelay method was interrupted", e);
        }
    }
}
