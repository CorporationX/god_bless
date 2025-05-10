package school.faang.dota;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class Dota2ItemCombiner {
    private static final int MILLIS = 1000;
    private static final int MILLIS2 = 1200;
    private static final ExecutorService executor = Executors.newFixedThreadPool(4);

    public static CompletableFuture<Item> getItemFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            sleep(MILLIS);
            Item item = new Item("Blades of Attack", 10);
            System.out.println("Получен из сундука: " + item);
            return item;
        }, executor);
    }

    public static CompletableFuture<Item> getItemFromShop() {
        return CompletableFuture.supplyAsync(() -> {
            sleep(MILLIS2);
            Item item = new Item("Broadsword", 15);
            System.out.println("Куплен в магазине: " + item);
            return item;
        }, executor);
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        CompletableFuture<Item> chestItemFuture = getItemFromChest();
        CompletableFuture<Item> shopItemFuture = getItemFromShop();

        CompletableFuture<Item> combinedItemFuture = chestItemFuture.thenCombine(
                shopItemFuture,
                inventory::combineItems
        );

        CompletableFuture<Void> finalResult = combinedItemFuture.thenCompose(inventory::addItemAsync);

        finalResult.join();

        executor.shutdown();
    }

}
