package school.faang.sprint_4.task_50734;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Inventory {
    private List<Item> chest = new ArrayList<>();

    private void addItem(Item item) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.warn("Add item interrupt", e);
            Thread.currentThread().interrupt();
        }
        chest.add(item);
        log.info("{} was added", item.getName());
    }


    public CompletableFuture<Void> collectItem(
            @NonNull Item requiredItemFromChest,
            @NonNull Item requiredItemFromShop
    ) {
        CompletableFuture<Item> itemFromChestFuture = CompletableFuture.supplyAsync(
                () -> getItemFromChest(requiredItemFromChest)
        );
        CompletableFuture<Item> itemFromShopFuture = CompletableFuture.supplyAsync(
                () -> getItemFromShop(requiredItemFromShop)
        );

        CompletableFuture<Item> combinedItemFuture = itemFromChestFuture.thenCombine(
                itemFromShopFuture,
                (itemFromChest, itemFromShop) -> {
                    Item combinedItem = combineItems(itemFromChest, itemFromShop);
                    log.info("{} was combined", combinedItem.getName());
                    return combinedItem;
                }
        );
        CompletableFuture<Void> addItemFuture = combinedItemFuture.thenCompose(
                (item) -> CompletableFuture.runAsync(() -> addItem(item))
        );
        combinedItemFuture.join();
        return addItemFuture;
    }

    private Item combineItems(Item item1, Item item2) {
        return new Item(item1.getName() + item2.getName(), item1.getPower() + item2.getPower());
    }

    private Item getItemFromChest(@NonNull Item item) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.warn("Get item from chest interrupt", e);
            Thread.currentThread().interrupt();
        }
        log.info("{} was taken from chest", item.getName());
        return new Item(item.getName(), item.getPower());
    }

    private Item getItemFromShop(@NonNull Item item) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.warn("Get item from shop interrupt", e);
            Thread.currentThread().interrupt();
        }
        log.info("{} was taken from shop", item.getName());
        return new Item(item.getName(), item.getPower());
    }
}
