package school.faang.sprint_4.task_50822;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Inventory {
    private static final long SIMULATION_EXECUTION_MILLIS = 3000;
    private static final int POWER_FIRST = 100;
    private static final int POWER_SECOND = 200;
    private final List<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item should not be empty!");
        }
        items.add(item);
        log.info("{} added", item.name());
    }

    public Item combineItems(Item first, Item second) {
        Item combiItem = new Item(first.name() + second.name(), first.power() + second.power());
        log.info("Combined element: {}", combiItem);
        return combiItem;
    }

    public CompletableFuture<Item> getItemFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(SIMULATION_EXECUTION_MILLIS);
            } catch (InterruptedException e) {
                log.error("Error message: ", e);
            }
            log.info("Item from chest received");
            return new Item("First", POWER_FIRST);
        });
    }

    public CompletableFuture<Item> getItemFromStore() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(SIMULATION_EXECUTION_MILLIS);
            } catch (InterruptedException e) {
                log.error("Error message: ", e);
            }
            log.info("Item from store received");
            return new Item("Second", POWER_SECOND);
        });
    }

    public CompletableFuture<Item> futureCombineItems(CompletableFuture<Item> first, CompletableFuture<Item> second) {
        return first.thenCombine(second, this::combineItems);
    }

    public void addItemToInventoryAsync(CompletableFuture<Item> combinedItem) {
        combinedItem.thenCompose(item -> CompletableFuture.runAsync(() -> addItem(item)));
    }
}
