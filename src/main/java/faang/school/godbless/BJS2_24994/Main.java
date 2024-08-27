package faang.school.godbless.BJS2_24994;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        List<Item> shop = List.of(new Item("Sword", 10),
                new Item("Bow", 6),
                new Item("Axe", 12),
                new Item("Gun", 20)
        );

        List<Item> box = List.of(new Item("Dagger", 8),
                new Item("Boomerang", 7),
                new Item("Knife", 5),
                new Item("Shuriken", 4)
        );

        Inventory inventory = new Inventory();
        CompletableFuture<Item> fromShop;
        CompletableFuture<Item> fromBox;
        CompletableFuture<Void> combined = null;

        for (int i = 0; i < shop.size(); i++) {
            fromShop = inventory.getFromShop(shop.get(i));
            fromBox = inventory.getFromBox(box.get(i));
            combined = fromShop.thenCombine(fromBox, inventory::combinedItem)
                    .thenCompose(item -> CompletableFuture.runAsync(() -> inventory.addItem(item)));
        }

        combined.join();
        inventory.getItems().forEach(item -> System.out.println(item.getName() + " - " + item.getPower()));
    }
}
