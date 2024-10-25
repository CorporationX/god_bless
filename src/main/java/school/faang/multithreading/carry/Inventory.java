package school.faang.multithreading.carry;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public Item combineItems(Item firstItem, Item secondItem) {
        int thirdItemPower = firstItem.getPower() + secondItem.getPower();
        return new Item("thirdItem", thirdItemPower);
    }

    private CompletableFuture<Item> getItemFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
                return new Item("firstItem", 5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private CompletableFuture<Item> getItemFromShop() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
                return new Item("secondItem", 15);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static void main(String[] args) throws InterruptedException {
        Inventory inventory = new Inventory();
        inventory.getItemFromChest()
                .thenCombine(inventory.getItemFromShop(), inventory::combineItems)
                .thenCompose(item -> CompletableFuture.runAsync(() -> inventory.addItem(item)));
    }
}
