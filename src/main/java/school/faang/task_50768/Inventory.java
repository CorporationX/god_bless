package school.faang.task_50768;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Inventory {
    private static final long PICK_UP_TIME = 1000;
    private List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Некорректное значение для предмета!");
        }

        items.add(item);
    }

    public Item combineItems(Item firstItem, Item secondItem) {
        return new Item(firstItem.name() + secondItem.name(), firstItem.power() + secondItem.power());
    }

    public CompletableFuture<Item> getItemFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            simulateDelay();
            return new Item("Item from chest", 100);
        });
    }

    public CompletableFuture<Item> getItemFromStore() {
        return CompletableFuture.supplyAsync(() -> {
            simulateDelay();
            return new Item("Item from store", 150);
        });
    }

    private static void simulateDelay() {
        try {
            Thread.sleep(PICK_UP_TIME);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток был прерван при выполнении метода sleep()", e);
        }
    }
}
