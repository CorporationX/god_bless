package faang.school.godbless.Sprint4Future.Carry;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        CompletableFuture<Item> item1 = CompletableFuture.supplyAsync(() -> new Item("Item1", 200));
        CompletableFuture<Item> item2 = CompletableFuture.supplyAsync(() -> new Item("Item2", 300));
        Inventory inventory = new Inventory();

        CompletableFuture<Item> itemCompletableFuture = item1.thenCombine(item2, inventory::combineItem);
        itemCompletableFuture.thenCompose(item -> CompletableFuture.runAsync(()-> inventory.addItem(item)));
        CompletableFuture.allOf(item1,item2).join();
        inventory.getItems().forEach(System.out::println);
    }
}

