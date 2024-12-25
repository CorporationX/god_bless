package school.faang.task_50683;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public Item combine(Item first, Item second) {
        return new Item(first.getName() + " + " + second.getName(), first.getPower() + second.getPower());
    }

    public CompletableFuture<Item> getFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return new Item("Swore", 10);
        });
    }

    public CompletableFuture<Item> buy() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return new Item("Spear", 20);
        });
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        CompletableFuture<Item> fromChest = inventory.getFromChest();
        CompletableFuture<Item> bought = inventory.buy();

        fromChest.thenCombine(bought, inventory::combine)
                .thenCompose(item -> CompletableFuture.runAsync(() -> inventory.add(item)))
                .join();
    }

}
