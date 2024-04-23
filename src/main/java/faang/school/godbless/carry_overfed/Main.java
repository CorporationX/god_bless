package faang.school.godbless.carry_overfed;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Inventory inventory = new Inventory();
        Item item1 = new Item("First", 10);
        Item item2 = new Item("Second", 13);

        inventory.addItem(item1);
        inventory.addItem(item2);

        CompletableFuture<Item> itemFromInventory = inventory.getItemFromInventory();
        CompletableFuture<Item> boughtItem = inventory.buyNewItemForCombine();

        CompletableFuture<Void> future = itemFromInventory.thenCombine(boughtItem, inventory::combineItems)
                .thenCompose(result -> CompletableFuture.runAsync(() -> inventory.addItem(result), executorService));

        future.join();
        executorService.shutdown();
        System.out.println(inventory.getItems());
    }
}