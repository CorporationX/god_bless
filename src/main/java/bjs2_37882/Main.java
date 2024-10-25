package bjs2_37882;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int TOTAL_THREADS = 5;
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(TOTAL_THREADS);

    public static void main(String[] args) {
        Shop shop = new Shop();
        Inventory inventory = new Inventory();

        Item mjolnir = new Item("Mjolnir", 100);
        Item monkeyKingBar = new Item("Monkey King Bar", 80);
        Item yasha = new Item("Yasha", 50);

        CompletableFuture<Void> addMjolnir = CompletableFuture.runAsync(() ->
                inventory.addItem(mjolnir), EXECUTOR_SERVICE);
        CompletableFuture<Void> addMonkeyKingBar = CompletableFuture.runAsync(() ->
                inventory.addItem(monkeyKingBar), EXECUTOR_SERVICE);
        CompletableFuture.allOf(addMjolnir, addMonkeyKingBar).join();

        CompletableFuture<Item> getMjolnir = CompletableFuture.supplyAsync(() -> inventory.getItem(mjolnir));
        CompletableFuture<Item> buyYasha = CompletableFuture.supplyAsync(() -> inventory.buyItem(shop, yasha));

        getMjolnir.thenCombine(buyYasha, inventory::combineItems);

        System.out.println(inventory);

        EXECUTOR_SERVICE.shutdown();
    }
}
