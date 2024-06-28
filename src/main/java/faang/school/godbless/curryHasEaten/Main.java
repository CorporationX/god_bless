package faang.school.godbless.curryHasEaten;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Inventory inventory = new Inventory();
        CompletableFuture<Item> completableFutureFromChest = inventory.getFromChest();
        CompletableFuture<Item> completableFutureBuy = inventory.buy();
        System.out.println("FromChest: " + completableFutureFromChest.get().getName() + " "
                + completableFutureFromChest.get().getPower());
        inventory.buy();
        System.out.println("Buy: " + completableFutureBuy.get().getName() + " "
                + completableFutureBuy.get().getPower());

        CompletableFuture<Item> completableFutureFromChestBuy = inventory.getFromChest()
                .thenCombine(inventory.buy(), inventory::combine);
        System.out.println("FromChest and Buy: " + completableFutureFromChestBuy.get().getName() + " "
                + completableFutureFromChestBuy.get().getPower());


        completableFutureBuy.thenCombine(completableFutureFromChest, inventory::combine)
                .thenCompose(item -> CompletableFuture.runAsync(() -> inventory.add(item)))
                .thenAccept(item -> {
                    System.out.println("FromChest and Buy async: " + item.getName()); // как тут вывести имя?
                });
    }
}