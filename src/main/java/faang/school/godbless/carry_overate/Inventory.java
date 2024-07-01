package faang.school.godbless.carry_overate;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Getter
public class Inventory {
    private final ExecutorService executorService =
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private final List<Item> items = new ArrayList<>();

    public CompletableFuture<Void> getCombinedItem() {
        return getItemFromChest().thenCombine(getItemFromStore(), this::combineItems)
                .thenCompose(resultItem -> CompletableFuture.runAsync(() -> addItem(resultItem)));
    }

    public Item combineItems(Item firstItem, Item secondItem) {
        String newItemName = firstItem.name() + "And" + secondItem.name();
        int newItemPower = firstItem.power() + secondItem.power();

        return new Item(newItemName, newItemPower);
    }

    public CompletableFuture<Item> getItemFromChest() {
        return CompletableFuture.supplyAsync(() -> {
                    log.info("Started opening chest");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        log.error("Getting item from chest was interrupted:", e);
                    }
                    log.info("You got a ChestItem with power 50");

                    return new Item("ChestItem", 50);
                }, executorService)
                .exceptionally(exception -> new Item("Default", 10));
    }

    public CompletableFuture<Item> getItemFromStore() {
        return CompletableFuture.supplyAsync(() -> {
                    log.info("Started trading in store");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        log.error("Getting item from store was interrupted:", e);
                    }
                    log.info("You got a StoreItem with power 50");

                    return new Item("StoreItem", 50);
                }, executorService)
                .exceptionally(exception -> new Item("Default", 10));
    }

    public synchronized void addItem(Item item) {
        items.add(item);
    }
}
