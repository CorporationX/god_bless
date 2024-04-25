package faang.school.godbless.carry;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public synchronized void addItem(Item item) {
        items.add(item);
    }

    public Item combineItems(Item first, Item second) {
        return new Item(first.getName() + second.getName(), first.getPower() + second.getPower());
    }

    public synchronized CompletableFuture<Item> getItemFromInventory(ExecutorService pool) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return items.get(ThreadLocalRandom.current().nextInt(0, items.size()));
        }, pool);
    }

    public CompletableFuture<Item> buy(ExecutorService pool) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return new Item("sword", 10);
        }, pool);
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }
}
