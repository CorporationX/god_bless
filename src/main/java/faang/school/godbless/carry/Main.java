package faang.school.godbless.carry;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        CompletableFuture<Item> itemFromChest = inventory.getItemFromChest();
        CompletableFuture<Item> itemFromShop = inventory.getItemFromShop();

        CompletableFuture<Void> futureResult = CompletableFuture.allOf(
                itemFromChest.thenCombine(itemFromShop, inventory::combineItems)
                        .thenCompose(item -> CompletableFuture.runAsync(() -> inventory.addItem(item))));

        futureResult.join();

        System.out.println("Добавили новое оружие - " + inventory.getItems().get(inventory.getItems().size() - 1));
    }
}
