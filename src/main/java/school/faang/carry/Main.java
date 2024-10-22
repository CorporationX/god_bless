package school.faang.carry;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private final static int COUNT_ITEMS = 10;

    public static void main(String[] args) {
        Chest chest = new Chest();
        Shop shop = new Shop();
        Inventory inventory = new Inventory();

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < COUNT_ITEMS; i++) {
            futures.add(CompletableFuture.supplyAsync(shop::getItem)
                    .thenCombine(
                            CompletableFuture.supplyAsync(chest::getItem),
                            inventory::combineItems)
                    .thenCompose(item ->
                            CompletableFuture.runAsync(() -> inventory.addItem(item))));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        inventory.printAllItems();
    }
}