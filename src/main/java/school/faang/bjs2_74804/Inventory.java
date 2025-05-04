package school.faang.bjs2_74804;

import lombok.extern.slf4j.Slf4j;
import school.faang.bjs2_73342.ThreadStoppageException;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

@Slf4j
public class Inventory {
    private final Executor poolThreads;
    private final List<Item> items = new CopyOnWriteArrayList<>();

    public Inventory(Executor poolThreads) {
        this.poolThreads = poolThreads;
    }

    public CompletableFuture<Item> addItem(Item item) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("New item {} added in inventory", item.name());
            items.add(item);
            return item;
        }, poolThreads);
    }

    public Item combineItems(Item firstItem, Item secondItem) {
        String newName = firstItem.name() + ' ' + secondItem.name();
        int newPower = firstItem.power() + secondItem.power();
        Item newItem = new Item(newName, newPower);
        log.info("Combined new item {}", newItem.name());
        return newItem;
    }

    public CompletableFuture<Item> getItemFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                throw new ThreadStoppageException(ex);
            }
            Item newItem = Chest.getItem();
            log.info("Got item {} from chest", newItem.name());
            return newItem;
        }, poolThreads);
    }

    public CompletableFuture<Item> getItemFromStore() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                throw new ThreadStoppageException(ex);
            }

            Item newItem = Store.getItem();
            log.info("Got item {} from store", newItem.name());
            return newItem;
        }, poolThreads);
    }

}
