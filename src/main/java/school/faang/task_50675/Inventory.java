package school.faang.task_50675;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Data
public class Inventory {
    private final List<Item> items = new ArrayList<>();
    private static final int PROCESS_TIME = 2000;

    public void addItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Error : 16, Inventory");
        }
        items.add(item);
    }

    public Item combineItem(Item item, Item item2) {
        if (item == null || item2 == null) {
            throw new IllegalArgumentException("Error : 23, Inventory");
        }
        String resultName = item.getName() + item2.getName();
        int resultPower = item.getPower() + item2.getPower();
        return new Item(resultName, resultPower);
    }

    public CompletableFuture<Item> getItemFromChest(ExecutorService executorService) {
        return proccessCompletableFuture(executorService, "Sword", 10, "chest", PROCESS_TIME);
    }

    public CompletableFuture<Item> getItemFromShop(ExecutorService executorService) {
        return proccessCompletableFuture(executorService, "Potion", 5, "shop", PROCESS_TIME);
    }

    public CompletableFuture<Item> proccessCompletableFuture(ExecutorService executorService,
                                                             String name,
                                                             int power,
                                                             String type,
                                                             int time) {
        return CompletableFuture.supplyAsync(() -> {
            Item item = new Item(name, power);
            System.out.println("Getting item from " + type);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Item was got from " + type);
            return item;
        }, executorService);
    }

    public CompletableFuture<Void> thenDoCombineCompose(CompletableFuture<Item> firstItem, CompletableFuture<Item> secondItem) {
        return firstItem.thenCombine(secondItem, this::combineItem)
                .thenCompose(item -> CompletableFuture.runAsync(() -> addItem(item)));
    }
}
