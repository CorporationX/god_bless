package faang.school.godbless.sprint4.dota;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Item sword = new Item("Sword", 10);
        Item shield = new Item("Shield", 5);
        inventory.addItem(sword);
        inventory.addItem(shield);

        CompletableFuture<Item> getFirstItem = CompletableFuture.supplyAsync(() -> {
            List<Item> items = inventory.getItems();
            if (items == null || items.isEmpty()) {
                throw new IllegalStateException("Inventory is empty");
            }
            return items.get(0);
        });

        CompletableFuture<Item> getSecondItem = CompletableFuture.supplyAsync(() -> {
            List<Item> items = inventory.getItems();
            if (items == null || items.size() < 2) {
                throw new IllegalStateException("Inventory does not contain two items");
            }
            return inventory.getItems().get(1);
        });

        CompletableFuture<Item> future3 = getFirstItem.thenCombine(getSecondItem, inventory::combineItems);

        CompletableFuture<Void> future4 = future3.thenCompose(inventory::addItemAsync);

        CompletableFuture<Void> future5 = future4.thenCombine(future3, (voidResult, itemResult) -> {
            System.out.println("Item " + itemResult.getName() + " with power " + itemResult.getPower() + " was successfully added to the inventory.");
            return voidResult;
        });

        try {
            future5.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
