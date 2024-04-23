package faang.school.godbless.carry_overfed;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Inventory {
    private final ExecutorService EXECUTOR_SERVICE;
    private List<Item> items;

    public synchronized List<Item> getItems() {
        return items;
    }

    public Inventory() {
        this.EXECUTOR_SERVICE = Executors.newFixedThreadPool(2);
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        getItems().add(item);
    }

    public CompletableFuture<Item> getItemFromInventory() {
        return CompletableFuture.supplyAsync(() ->
                getItems().get(new Random().nextInt(0, getItems().size())),
                EXECUTOR_SERVICE
        );
    }

    public CompletableFuture<Item> buyNewItemForCombine() {
        Random random = new Random();
        return CompletableFuture.supplyAsync(() ->
                new Item(
                        "Item" + random.nextInt(0, 1000),
                        random.nextInt(1, 100)
                ), EXECUTOR_SERVICE
        );
    }

    public Item combineItems(Item itemFromInventory, Item itemFromStore) {
        return new Item(
                itemFromInventory.getName() + "-" + itemFromStore.getName().toLowerCase(),
                itemFromInventory.getPower() + itemFromStore.getPower()
        );
    }

    public void shutdown() {
        EXECUTOR_SERVICE.shutdown();
    }
}