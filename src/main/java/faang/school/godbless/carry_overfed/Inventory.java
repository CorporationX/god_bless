package faang.school.godbless.carry_overfed;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
public class Inventory {
    private List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public CompletableFuture<Item> getItemFromInventory() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<Item> future =  CompletableFuture.supplyAsync(() ->
                items.get(new Random().nextInt(0, items.size())),
                executorService
        );
        executorService.shutdown();
        return future;
    }

    public CompletableFuture<Item> buyNewItemForCombine() {
        Random random = new Random();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<Item> future =  CompletableFuture.supplyAsync(() ->
                        new Item(
                                "Item" + random.nextInt(0, 1000),
                                random.nextInt(1, 100)
                        ), executorService
        );
        executorService.shutdown();
        return future;
    }

    public Item combineItems(Item itemFromInventory, Item itemFromStore) {
        return new Item(
                itemFromInventory.getName() + "-" + itemFromStore.getName().toLowerCase(),
                itemFromInventory.getPower() + itemFromStore.getPower()
        );
    }

}