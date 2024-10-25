package school.faang.godbless.bjs2_38810;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class InventoryManager implements AutoCloseable {
    private static final int MIN_TIMEOUT = 1000;
    private static final int MAX_TIMEOUT = 2000;
    private static final int MAX_POWER = 100;
    private static final int MIN_POWER = 10;

    private final ExecutorService pool = Executors.newCachedThreadPool();
    private final Inventory inventory = new Inventory();

    public CompletableFuture<Item> getFromShop() {
        String itemName = "ShopItem" + System.currentTimeMillis();
        return getItem(itemName);
    }

    public CompletableFuture<Item> getFromChest() {
        String itemName = "ChestItem" + System.currentTimeMillis();
        return getItem(itemName);
    }

    public CompletableFuture<Item> combineItems(CompletableFuture<Item> item1, CompletableFuture<Item> item2) {
        return item2.thenCombine(item1, inventory::combineItems);
    }

    public void addToInventory(CompletableFuture<Item> item) {
        item.thenCompose(itemToAdd -> CompletableFuture.runAsync(() -> inventory.addItem(itemToAdd))).join();
    }

    @Override
    public void close() {
        pool.shutdown();
    }

    private CompletableFuture<Item> getItem(String itemName) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("Thread {} : getting an item {}", Thread.currentThread().getName(), itemName);
            Random random = ThreadLocalRandom.current();
            try {
                Thread.sleep(random.nextInt(MIN_TIMEOUT, MAX_TIMEOUT + 1));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Interrupted when getting item from the shop");
            }
            return new Item(itemName, random.nextInt(MIN_POWER, MAX_POWER + 1));
        }, pool);
    }
}
