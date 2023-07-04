package faang.school;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        var sword = new Item("Sword", 10);
        var shield = new Item("Shield", 10);
        Inventory inventory = new Inventory(new ArrayList<>(Arrays.asList(shield, sword)));
        var firstItem = getFirstItem(inventory);
        var secondItem = getSecondItem(inventory);

        secondItem.thenCombine(firstItem, inventory::combineItems).thenComposeAsync(combinedItem -> {
            try {
                inventory.addItem(combinedItem.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException("Dead");
            }
            return CompletableFuture.completedFuture(null);
        }).join();
        System.out.println(inventory.getItems());
    }

    private static CompletableFuture<Item> getFirstItem(Inventory inventory) {
        synchronized (inventory) {
            return CompletableFuture.supplyAsync(() -> {
                var items = inventory.getItems();
                if (items == null || items.isEmpty()) {
                    throw new ArrayIndexOutOfBoundsException("Inventory in empty!");
                }
                return items.get(0);
            });
        }
    }

    private static CompletableFuture<Item> getSecondItem(Inventory inventory) {
        synchronized (inventory) {
            return CompletableFuture.supplyAsync(() -> {
                var items = inventory.getItems();
                if (items == null || items.size() < 2) {
                    throw new ArrayIndexOutOfBoundsException("Inventory doesn`t contain the second item!");
                }
                return items.get(1);
            });
        }
    }
}
