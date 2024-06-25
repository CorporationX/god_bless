package faang.school.godbless.multithreading_async.task_10;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
public class Inventory {
    private final List<Item> items = new ArrayList<>();

    private static final int GAINING_ITEM_DURATION = 4000;

    public void addItem(Item item) {
        items.add(item);
        log.info("Added item {} with power {}", item.name(), item.power());
    }

    public Item combineItem(Item firstItem, Item secondItem) {
        return new Item(String.join(" ", firstItem.name(), secondItem.name()),
                firstItem.power() + secondItem.power());
    }

    public CompletableFuture<Item> getItemFromChest(ExecutorService executor) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(GAINING_ITEM_DURATION);
            } catch (InterruptedException e) {
                log.error("Thread was interrupted while retrieving item from chest", e);
                Thread.currentThread().interrupt();
            }
            return new Item("Infinity", 100);
        }, executor);
    }

    public CompletableFuture<Item> getItemFromShop(ExecutorService executor) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(GAINING_ITEM_DURATION);
            } catch (InterruptedException e) {
                log.error("Thread was interrupted while retrieving item from shop", e);
                Thread.currentThread().interrupt();
            }
            return new Item("Blade", 50);
        }, executor);
    }
}