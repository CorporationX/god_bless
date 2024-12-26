package school.faang.task_50715;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
@RequiredArgsConstructor
public class Inventory {
    private static final int SHOP_DELAY = 3000;
    private static final int CHEST_DELAY = 1000;

    private final ExecutorService executorService;
    private final List<Item> items = new ArrayList<>();

    private CompletableFuture<Item> getItemFromShop() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(SHOP_DELAY);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
            Item item = Shop.getRandomItem();
            log.info("Item from shop: {}", item);
            return item;
        }, executorService);
    }

    private CompletableFuture<Item> getItemFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(CHEST_DELAY);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
            Item item = Chest.getRandomItem();
            log.info("Item from chest: {}", item);
            return item;
        }, executorService);
    }

    public void combineItemsAndAddToInventory() {
        getItemFromShop()
                .thenCombine(getItemFromChest(), (itemFromShop, itemFromChest) -> {
                    String combinedItemName = itemFromShop.getName() + " " + itemFromChest.getName();
                    int combinedItemPower = itemFromShop.getPower() + itemFromChest.getPower();

                    Item combinedItem = new Item(combinedItemName, combinedItemPower);
                    log.info("Combined item: {}", combinedItem);
                    return combinedItem;
                }).thenCompose(combinedItem -> {
                    return CompletableFuture.runAsync(() -> {
                        items.add(combinedItem);
                        log.info("{} added to inventory", combinedItem);
                    });
                });
    }
}
