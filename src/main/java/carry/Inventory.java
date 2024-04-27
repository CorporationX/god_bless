package carry;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class Inventory {
    private static final int AMOUNT_OF_THREADS = 10;
    private static final ExecutorService SERVICE = Executors.newFixedThreadPool(AMOUNT_OF_THREADS);
    private final List<Item> items = new CopyOnWriteArrayList<>();

    public void addItem(Item item) {
        checkItem(item);
        items.add(item);
    }

    public Item combineItems(Item item1, Item item2) {
        checkItem(item1);
        checkItem(item2);
        return new Item(item1.getName() + "+" + item2.getName().toLowerCase(),
                item1.getPower() + item2.getPower());
    }

    public CompletableFuture<Item> getItemFromInventory() {
        return CompletableFuture.supplyAsync(
                () -> {
                    Item item = items.get(ThreadLocalRandom.current().nextInt(0, items.size()));
                    items.removeIf(item1 -> item1.equals(item));
                    return item;
                },
                SERVICE);
    }

    public CompletableFuture<Item> getItemFromShop() {
        return CompletableFuture.supplyAsync(Shop::getItem, SERVICE);
    }

    public void combineItemsAndAddInInventory() {
        getItemFromInventory().thenCombine(getItemFromShop(),
                        (item1, item2) -> CompletableFuture.supplyAsync(
                                () -> combineItems(item1, item2), SERVICE))
                .thenCompose(item -> CompletableFuture.runAsync(
                        () -> addItem(item.join()), SERVICE));
    }

    private void checkItem(Item item) {
        if (item == null) {
            throw new NullPointerException("Item must be exist");
        }
    }

    public void shutdown() {
        SERVICE.shutdown();
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }
}
