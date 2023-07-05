package faang.school.godbless.CarryGotFat;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Game {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        CompletableFuture.supplyAsync(()->receiveFromChest("item1"))
                .thenCombine(receiveFromStore("item2"), (f1,f2) -> {
                    try {
                        return inventory.combineItems(f1.get(),f2);
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                }).thenCompose(item -> CompletableFuture.runAsync(() -> inventory.addItem(item)));

        System.out.println(inventory);
    }

    public static CompletableFuture<Item> receiveFromChest(String name) {
        return CompletableFuture.supplyAsync(() -> new Item(name, new Random().nextInt(100)));
    }

    public static CompletableFuture<Item> receiveFromStore(String name) {
        return CompletableFuture.supplyAsync(() -> new Item(name, new Random().nextInt(100)));
    }

}
