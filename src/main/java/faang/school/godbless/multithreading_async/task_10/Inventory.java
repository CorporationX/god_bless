package faang.school.godbless.multithreading_async.task_10;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Inventory {
    private final List<Item> items = new ArrayList<>();

    private static final int GAINING_ITEM_DURATION = 4000;
    private static final int THREAD_COUNT = 4;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(THREAD_COUNT);

    public void addItem(Item item) {
        items.add(item);
        log.info("Added item {} with power {}", item.name(), item.power());
    }

    public Item combineItem(Item firstItem, Item secondItem) {
        return new Item(String.join(" ", firstItem.name(), secondItem.name()),
            firstItem.power() + secondItem.power());
    }

    public CompletableFuture<Item> getItemFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(GAINING_ITEM_DURATION);
            } catch (InterruptedException e) {
                log.error("Thread was interrupted while retrieving item from chest", e);
                Thread.currentThread().interrupt();
            }
            return new Item("Infinity", 100);
        }, EXECUTOR);
    }

    public CompletableFuture<Item> getItemFromShop() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(GAINING_ITEM_DURATION);
            } catch (InterruptedException e) {
                log.error("Thread was interrupted while retrieving item from shop", e);
                Thread.currentThread().interrupt();
            }
            return new Item("Blade", 50);
        }, EXECUTOR);
    }

    public void shutdownExecutor() {
        EXECUTOR.shutdown();
    }
}