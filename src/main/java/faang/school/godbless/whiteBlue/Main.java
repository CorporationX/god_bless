package faang.school.godbless.whiteBlue;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);

        Inventory inventory = new Inventory();
        inventory.addItem(
                new Item("oldItem", 10)
        );

        CompletableFuture<Item> combinedItem =
                CompletableFuture.supplyAsync(Main::getItemFromChest, service)
                        .thenCombine(CompletableFuture.supplyAsync(Main::getItemFromStore, service),
                                Inventory::combineItems);

        combinedItem.thenAccept(
                inventory::addItem
        );

        combinedItem.thenCompose(item ->
                CompletableFuture.runAsync(() -> inventory.addItem(item), service)
        );

        service.shutdown();
        try {
            if (!service.awaitTermination(4000, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }
        System.out.println(Arrays.toString(inventory.getItems().toArray(new Item[0])));
    }

    private static Item getItemFromChest() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new Item("itemFromChest", 120);
    }

    private static Item getItemFromStore() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new Item("itemFromStore", 50);
    }
}
