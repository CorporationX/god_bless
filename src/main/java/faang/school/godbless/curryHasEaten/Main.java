package faang.school.godbless.curryHasEaten;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Inventory inventory = new Inventory();
        Item item1 = new Item("Sword " + LocalDateTime.now().format(dateTimeFormatter), 10);
        Item item2 = new Item("Sword " + LocalDateTime.now().format(dateTimeFormatter), 10);
        Item item3 = new Item("Spear " + LocalDateTime.now().format(dateTimeFormatter), 20);
        Item item4 = new Item("Spear " + LocalDateTime.now().format(dateTimeFormatter), 20);
        inventory.addItemChest(item1);
        inventory.addItemChest(item2);
        inventory.addItemBuy(item3);
        inventory.addItemBuy(item4);

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
                .thenCompose(item -> CompletableFuture.supplyAsync(() -> inventory.addItemChest(item)))
                .thenAccept(item -> {
                    System.out.println("FromChest and Buy async: " + item);
                });
    }
}