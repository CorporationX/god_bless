package faang.school.godbless.sprint_3.multithreading_future.carry_feeded;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        CompletableFuture<Item> first = inventory.getItemFromChest();
        CompletableFuture<Item> second = inventory.getItemFromMarket(3);
        first.thenCombine(second, (firstResult, secondResult) -> CompletableFuture.supplyAsync(() -> inventory.combineItems(firstResult, secondResult)))
                .thenCompose(result -> result.thenAcceptAsync(inventory::addItem))
                .join();
        System.out.println(inventory.getItems().get(0).getName());
    }
}