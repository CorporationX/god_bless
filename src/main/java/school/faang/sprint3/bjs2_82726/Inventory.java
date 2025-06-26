package school.faang.sprint3.bjs2_82726;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Inventory {
    public static final int THREAD_POOL_BATCH = 5;

    private final ExecutorService executorService;
    private final List<Item> items = new ArrayList<>();
    private final Object lock = new Object();

    public Inventory(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public CompletableFuture<Boolean> addItem(Item item) {
        synchronized (lock) {
            return CompletableFuture.supplyAsync(() -> items.add(item), executorService);
        }
    }

    public CompletableFuture<Item> getItemFromChest() {
        return CompletableFuture.supplyAsync(() -> items.stream()
                .findFirst()
                .orElseGet(() -> {
                    Item generated = new Item(
                            generateItemName(),
                            ThreadLocalRandom.current().nextInt(0, 100)
                    );
                    System.out.println("Получен предмет из инвентаря: " + generated);
                    return generated;
                }));
    }

    public CompletableFuture<Item> getItemFromShop() {
        return CompletableFuture.supplyAsync(() -> {
            Item item = new Item(
                    generateItemName(),
                    ThreadLocalRandom.current().nextInt(0, 100)
            );
            System.out.println("Получен предмет из магазина: " + item);
            return item;

        });
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_BATCH);
        Inventory inventory = new Inventory(executorService);

        CompletableFuture<Item> inventoryItem = inventory.getItemFromChest();
        CompletableFuture<Item> inventoryShop = inventory.getItemFromShop();
        CompletableFuture<Void> combineItemsAndAddToInventory = inventoryItem
                .thenCombine(inventoryShop,
                        (item1, item2) -> new Item(
                                item1.getName() + "_" + item2.getName(),
                                item1.getPower() + item2.getPower()
                        ))
                .thenAccept(item -> {
                    inventory.addItem(item);
                    System.out.println("Добавлен предмет: " + item);
                });
        combineItemsAndAddToInventory.join();

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

    }

    public static String generateItemName() {
        return new java.util.Random()
                .ints(8, 'a', 'z' + 1)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
