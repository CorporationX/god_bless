package school.faang.BJS239151;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Inventory {
    private List<Item> itemList = new ArrayList<>();
    private static final int THREADS = 2;
    private final ExecutorService executorService = Executors.newFixedThreadPool(THREADS);

    public void addItem(Item item) {
        itemList.add(item);
    }

    public CompletableFuture<Void> combineAndAddItems() {
        CompletableFuture<Item> chestItemFuture = getItemFromChest();
        CompletableFuture<Item> shopItemFuture = getItemFromShop();

        CompletableFuture<Item> combinedItemFuture = chestItemFuture.thenCombine(shopItemFuture, (item1, item2) -> {
            Item combinedItem = new Item(item1.getName() + "-" + item2.getName(), item1.getPower() + item2.getPower());
            System.out.println("Скомбинированный предмет: " + combinedItem.getName());
            return combinedItem;
        });

        return combinedItemFuture.thenCompose(this::addItemToInventoryAsync);
    }

    public CompletableFuture<Item> getItemFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error("Что-то пошло не так ", e);
            }
            return new Item("Chest Item", 10);
        },executorService);
    }

    public CompletableFuture<Item> getItemFromShop() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error("Что-то пошло не так ", e);
            }
            return new Item("Shop Item", 20);
        }, executorService);
    }

    public CompletableFuture<Void> addItemToInventoryAsync(Item item) {
        return CompletableFuture.runAsync(() -> {
            this.addItem(item);
            System.out.println("Предмет добавлен в инвентарь: " + item.getName());
        });
    }
}
