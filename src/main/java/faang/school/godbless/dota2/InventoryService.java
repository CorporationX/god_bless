package faang.school.godbless.dota2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class InventoryService {
    public static CompletableFuture<Item> getItemFromBox() {
        return CompletableFuture.supplyAsync(
                () -> new Item("ItemFromBox", 100));
    }

    public static CompletableFuture<Item> getItemFromStore() {
        return CompletableFuture.supplyAsync(
                () -> new Item("ItemFromStore", 500));
    }

    public static CompletableFuture<Item> combineItems(Item item1, Item item2, Inventory inventory) {
        return CompletableFuture.supplyAsync(
                () -> inventory.combineItems(item1, item2));
    }

    public static CompletableFuture<Void> addItem(Item item, Inventory inventory) {
        return CompletableFuture.runAsync(
                () -> inventory.addItem(item));
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Inventory inventory = new Inventory();

        CompletableFuture.supplyAsync(InventoryService::getItemFromBox)
                .thenCombine(CompletableFuture.supplyAsync(InventoryService::getItemFromStore),
                        (item1, item2) -> {
                            try {
                                return InventoryService.combineItems(item1.get(), item2.get(), inventory);
                            } catch (InterruptedException | ExecutionException e) {
                                System.out.println("Combining items failed");
                                return new CompletableFuture<Item>();
                            }
                        }).thenCompose(item -> CompletableFuture.supplyAsync(() -> {
                            try {
                                return InventoryService.addItem(item.get(), inventory);
                            } catch (InterruptedException | ExecutionException e) {
                                System.out.println("Adding item failed");
                                return new CompletableFuture<Void>();
                            }
                        })).get();

        System.out.println(inventory.getItems());
    }
}
