package school.faang.m1s4.bsj2_38762_dota;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@ToString
@Slf4j
public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public void combineItems(Item shopItem, Item chestItem) {
        CompletableFuture<Item> getItemFromShop = getItemFromShop(shopItem);

        CompletableFuture<Item> getItemFromChest = getItemFromChest(chestItem);

        CompletableFuture<Item> combinedItem = getItemFromShop.thenCombine(getItemFromChest,
                        (firstItem, secondItem) ->
                                new Item(firstItem.getName() + " " + secondItem.getName(),
                                        (firstItem.getPower()) + secondItem.getPower()))
                .thenCompose(item -> CompletableFuture.supplyAsync(() -> {
                    addItem(item);
                    log.info("You combined {} and {} successfully", shopItem.getName(), chestItem.getName());
                    log.info("You've got {} {} ({} power)", shopItem.getName(), chestItem.getName(), (shopItem.getPower() + chestItem.getPower()));
                    return null;
                }));

        combinedItem.join();
    }

    private synchronized void addItem(Item item) {
        items.add(item);
    }


    private CompletableFuture<Item> getItemFromShop(Item shopItem) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextLong(1000, 4000));
            } catch (InterruptedException e) {
                log.error("Thread has been interrupted", e);
            }
            log.info("You bought {} ({} power)", shopItem.getName(), shopItem.getPower());
            return shopItem;
        });
    }

    private CompletableFuture<Item> getItemFromChest(Item chestItem) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextLong(1000, 4000));
            } catch (InterruptedException e) {
                log.error("Thread has been interrupted", e);
            }
            log.info("You found {} ({} power)", chestItem.getName(), chestItem.getPower());
            return chestItem;
        });
    }
}
