package faang.school.godbless.dota2;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        CompletableFuture<Item> getFromInventory = CompletableFuture.supplyAsync(() ->
                new Item("Mystic Staff", 100));

        CompletableFuture<Item> getFromShop = CompletableFuture.supplyAsync(() ->
                new Item("Platemail", 75));

        CompletableFuture<Item> combineItems = getFromInventory.thenCombine(getFromShop, inventory::combineItems);

        CompletableFuture<String> addItemToInventory = combineItems.thenCompose(item -> {
            CompletableFuture<String> future = new CompletableFuture<>();
            inventory.addItem(item);
            future.complete("Предмет добавлен в инвентарь");
            return future;
        });

        CompletableFuture<Void> result = addItemToInventory.thenAccept(i -> {
            System.out.println("Все действия выполнены");
        });

        result.join();
    }
}
