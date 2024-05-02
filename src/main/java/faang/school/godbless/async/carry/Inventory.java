package faang.school.godbless.async.carry;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class Inventory {
    private static final Long GETTING_TIMING = 500L;
    private final ExecutorService executor = Executors.newCachedThreadPool();
    private final List<Item> items = new ArrayList<>();

    public CompletableFuture<Item> addItem(Item item) {
        return CompletableFuture.supplyAsync(() -> {
                    if (item == null) {
                        throw new IllegalArgumentException("Item cannot be null!");
                    }

                    try {
                        Thread.sleep(ThreadLocalRandom.current().nextLong(0, GETTING_TIMING));
                    } catch (InterruptedException e) {
                        log.error("Adding " + item.name() + " item was interrupted.");
                    }

                    items.add(item);

                    log.info("The " + item.name() + " item added to the inventory.");

                    return item;
                }, executor)
                .exceptionally(this::logException);
    }

    public CompletableFuture<Item> getItem(Item item) {
        return CompletableFuture.supplyAsync(() -> {
                    if (!items.contains(item)) {
                        throw new NoSuchElementException("Cannot get " + item.name() + " from the inventory. The inventory doesn't contain this item.");
                    }

                    try {
                        Thread.sleep(ThreadLocalRandom.current().nextLong(0, GETTING_TIMING));
                    } catch (InterruptedException e) {
                        log.error("Getting item was interrupted.");
                    }

                    return items.remove(items.indexOf(item));
                }, executor)
                .exceptionally(this::logException);
    }

    public synchronized CompletableFuture<Item> combineItems(Item itemA, Item itemB) {
        var itemAFromInventory = getItem(itemA);
        var itemBFromInventory = getItem(itemB);

        return itemAFromInventory.thenCombine(itemBFromInventory, (gottenItemA, gottenItemB) -> {
                    if (gottenItemA == null && gottenItemB == null) {
                        throw new NoSuchElementException("Cannot combine non-existent items.");
                    }

                    checkNullvalue(gottenItemA, gottenItemB);

                    checkNullvalue(gottenItemB, gottenItemA);

                    String combinedItemName = "Combined " + gottenItemA.name() + " and " + gottenItemB.name();
                    int combinedItemPower = gottenItemA.power() + gottenItemB.power();

                    try {
                        Thread.sleep(ThreadLocalRandom.current().nextLong(0, GETTING_TIMING * 2));
                    } catch (InterruptedException e) {
                        log.error("The items (" + gottenItemA.name() + " and " + gottenItemB.name() + ") combining was interrupted.");
                    }

                    return new Item(combinedItemName, combinedItemPower);
                })
                .exceptionally(this::logException)
                .thenCompose(this::addItem);
    }

    public List<Item> getItems() {
        return items;
    }

    public void close() {
        executor.shutdown();
    }

    private Item logException(Throwable e) {
        log.error("Exception was caught", e);

        return null;
    }

    private void checkNullvalue(Item possibleNull, Item notNullItem) {
        if (possibleNull == null) {
            addItem(notNullItem).join();
            throw new NoSuchElementException("Cannot combine non-existent items.");
        }
    }
}
