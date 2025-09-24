package school.faang.bjs2_94777;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Inventory {
    private static final int THREAD_COUNT = 3;
    private static final int AWAIT_MINUTES = 1;
    private static final ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Предмет не может быть пустым");
        }
        items.add(item);
    }

    public Item combineItems(Item itemFirs, Item itemSecond) {
        CompletableFuture<Item> combine = CompletableFuture.supplyAsync(() -> {
            String newName = itemFirs.getName() + itemSecond.getName();
            int totalPower = itemFirs.getPower() + itemSecond.getPower();
            return new Item(newName, totalPower);
        }, executor);
        return null;
    }

    public void processorInventory(int index) {
        CompletableFuture<Item> firstItem = CompletableFuture.supplyAsync(() -> {
            Chest chest = new Chest();
            return chest.getItem(index);
        }, executor);
        CompletableFuture<Item> secondItem = CompletableFuture.supplyAsync(() -> {
            Magazine magazine = new Magazine();
            return magazine.getItem(index);
        }, executor);



    }
}
