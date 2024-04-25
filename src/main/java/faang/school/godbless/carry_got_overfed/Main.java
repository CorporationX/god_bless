package faang.school.godbless.carry_got_overfed;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        CompletableFuture<Item> chestFuture = CompletableFuture.supplyAsync(() -> new Item("Меч", 10));
        CompletableFuture<Item> shopFuture = CompletableFuture.supplyAsync(() -> new Item("Модный наконечник", 5));

        CompletableFuture<Item> combinedFuture = chestFuture.thenCombine(shopFuture, (item1, item2) -> {
            Inventory inventory = new Inventory();
            inventory.combineItem(item1, item2);
            return inventory.getItems().get(0);
        });

        CompletableFuture<Void> addToInventoryFuture = combinedFuture.thenCompose(combinedItem ->
                CompletableFuture.runAsync(() -> {
                    Inventory playerInventory = new Inventory();
                    playerInventory.addItem(combinedItem);
                    System.out.println("Добавлено модифицированное оружие " + combinedItem.getName()
                            + " в инвентарь игрока с силой " + combinedItem.getPower());
                }));
        addToInventoryFuture.join();
    }
}
