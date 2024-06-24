package BJS2_14332;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Data
public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public Item combine(Item firstItem, Item secondItem) {
        return new Item(firstItem.name() + " + " + secondItem.name(), firstItem.power() + secondItem.power());
    }

    public CompletableFuture<Item> getFromChest() {
        return CompletableFuture.supplyAsync(() -> new Item("Sword", 10));
    }

    public CompletableFuture<Item> buy() {
        return CompletableFuture.supplyAsync(() -> new Item("Spear", 20));
    }
}
