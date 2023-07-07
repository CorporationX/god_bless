package carry_got_fat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Inventory {
    private final List<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public synchronized List<Item> getItems() {
        return new ArrayList<>(items);
    }

    public CompletableFuture<Item> openChest() {
        return CompletableFuture.supplyAsync(() -> {
            Item item = new Item("Platemail", 10);
            items.add(item);
            System.out.println("Received from the chest: " + item.getName());
            return item;
        });
    }

    public CompletableFuture<Item> buyItem() {
        return CompletableFuture.supplyAsync(() -> {
            Item item = new Item("Claymore", 20);
            items.add(item);
            System.out.println("Bought from shop: " + item.getName());
            return item;
        });
    }

    public CompletableFuture<Void> addToInventory(Item item) {
        return CompletableFuture.runAsync(() -> {
            items.add(item);
            System.out.println(item.getName() + " added to inventory");
        });
    }

    public Item combineItems(Item item1, Item item2) {
        int combinedPower = item1.getPower() + item2.getPower();
        String combinedName = item1.getName() + "-" + item2.getName();
        return new Item(combinedName, combinedPower);
    }

    public void showInventory() {
        System.out.println("\nInventory: ");
        for (Item item : items) {
            System.out.println(item);
        }
    }
}
