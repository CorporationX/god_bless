package faang.school.godbless.carry_overfed;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadLocalRandom;

@Getter
public class Inventory {
    private static final List<String> ITEMS_CHEST = List.of("Item1", "Item2", "Item3", "Item4", "Item5", "Item6", "Item7", "Item8", "Item9", "Item10");
    private static final List<String> ITEMS_SHOP = List.of("Item11", "Item12", "Item13", "Item14", "Item15", "Item16", "Item17", "Item18", "Item19", "Item20");
    private List<Item> items = new ArrayList<>();

    public synchronized void addItem(Item item) {
        items.add(item);
    }

    public Item combineItems(Item first, Item second) {
        return new Item(first.getName() + second.getName(), first.getPower() + second.getPower());
    }

    public CompletableFuture<Item> getFromChest(Executor executor) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(Thread.currentThread().getName() + " interrupted");
            }

            String name = ITEMS_CHEST.get(ThreadLocalRandom.current().nextInt(ITEMS_CHEST.size()));
            int power = ThreadLocalRandom.current().nextInt(100);
            return new Item(name, power);
        }, executor);
    }

    public CompletableFuture<Item> getFromShop(Executor executor) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(Thread.currentThread().getName() + " interrupted");
            }

            String name = ITEMS_SHOP.get(ThreadLocalRandom.current().nextInt(ITEMS_SHOP.size()));
            int power = ThreadLocalRandom.current().nextInt(100);
            return new Item(name, power);
        }, executor);
    }
}
