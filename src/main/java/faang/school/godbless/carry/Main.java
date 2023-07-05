package faang.school.godbless.carry;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        CompletableFuture<Item> chestItemFuture = CompletableFuture.supplyAsync(Main::openChest);
        CompletableFuture<Item> shopItemFuture = CompletableFuture.supplyAsync(Main::visitShop);

        CompletableFuture<Item> combinedItemFuture = chestItemFuture.thenCombine(shopItemFuture, Inventory::combineItems);

        CompletableFuture<Void> addToInventoryFuture = combinedItemFuture.thenCompose(Main::addToInventory);

        CompletableFuture.allOf(addToInventoryFuture).join();

        System.out.println("Все операции завершены");
    }

    private static Item openChest() {
        Item item = new Item("Меч", 10);
        System.out.println("Открываем сундук: " + item.getName());
        return item;
    }

    private static Item visitShop() {
        Item item = new Item("Щит", 5);
        System.out.println("Посещаем магазин: " + item.getName());
        return item;
    }

    private static CompletableFuture<Void> addToInventory(Item combinedItem) {
        Inventory inventory = new Inventory();
        inventory.addItem(combinedItem);
        return CompletableFuture.runAsync(() -> {
        });
    }

}
