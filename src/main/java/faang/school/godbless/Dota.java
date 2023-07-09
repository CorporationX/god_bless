package faang.school.godbless;

import java.util.concurrent.CompletableFuture;

public class Dota {
    public static void main(String[] args) {
        CompletableFuture<Item> openChest = CompletableFuture.supplyAsync(() -> {
            System.out.println("Opening chest...");
            return new Item("Sword", 10);
        });

        CompletableFuture<Item> buyItem = CompletableFuture.supplyAsync(() -> {
            System.out.println("Buying item...");
            return new Item("Shield", 5);
        });

        CompletableFuture<Item> combineItems = openChest.thenCombine(buyItem, (item1, item2) -> {
            System.out.println("Combining items...");
            int combinedPower = item1.getPower() + item2.getPower();
            String combinedName = item1.getName() + " + " + item2.getName();
            return new Item(combinedName, combinedPower);
        });

        Inventory inventory = new Inventory();

        CompletableFuture<Void> addToInventory = combineItems.thenCompose(item -> {
            System.out.println("Adding item to inventory...");
            CompletableFuture<Void> future = new CompletableFuture<>();
            inventory.addItem(item);
            future.complete(null);
            return future;
        });

        CompletableFuture<Void> result = addToInventory.thenAccept(ignore -> {
            System.out.println("All operations completed");
        });

        result.join();
    }
}
