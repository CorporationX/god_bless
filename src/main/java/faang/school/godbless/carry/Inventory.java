package faang.school.godbless.carry;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Inventory {

    private final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();
    private final Map<String, Item> ITEMS = new ConcurrentHashMap<>();

    public void addItem(Item item) {
        ITEMS.put(item.getName(), item);
    }

    public CompletableFuture<Item> getFromInventory(String itemName) {
        return CompletableFuture.supplyAsync(() -> ITEMS.get(itemName), EXECUTOR_SERVICE);
    }

    public CompletableFuture<Item> getFromShop(String itemName) {
        return CompletableFuture.supplyAsync(() -> new Item(itemName, 3), EXECUTOR_SERVICE);
    }

    public CompletableFuture<Void> combineItems(CompletableFuture<Item> item1, CompletableFuture<Item> item2) {
        return item1.thenCombine(item2, this::mergeItems)
                .thenCompose(this::putInInventory)
                .thenRun(() -> removeItems(List.of(item1, item2)));
    }

    public void shutdownAndAwaitExecution(Long minutes) {
        EXECUTOR_SERVICE.shutdown();
        awaitExecution(minutes);
    }

    private void removeItems(List<CompletableFuture<Item>> items) {
        for (var item : items) {
            ITEMS.remove(getFromFuture(item).getName());
        }
    }

    private Item mergeItems(Item i1, Item i2) {
        return new Item(String.format("%s %s", i1.getName(), i2.getName()), i1.getPower() + i2.getPower());
    }

    private CompletableFuture<Item> putInInventory(Item item) {
        return CompletableFuture.supplyAsync(() -> {
            ITEMS.put(item.getName(), item);
            return item;
        }, EXECUTOR_SERVICE);
    }

    private void awaitExecution(Long minutes) {
        try {
            EXECUTOR_SERVICE.awaitTermination(minutes, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static <T> T getFromFuture(Future<T> future) {
        try {
            return future.get(30L, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } catch (ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}