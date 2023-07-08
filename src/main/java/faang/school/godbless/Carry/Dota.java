package faang.school.godbless.Carry;

import java.util.concurrent.CompletableFuture;

public class Dota {
    static Inventory inventory = new Inventory();

    public static void main(String[] args) {


        Item item1 = new Item("Штык", 4);
        Item item2 = new Item("Нож", 5);

        getItemFromChest(item1)
                .thenCombine(getItemFromShop(item2), (itm1, itm2) -> inventory.combineItems(itm1, itm2))
                .thenCompose(item -> CompletableFuture.runAsync(() -> inventory.addItem(item)))
                .thenRun(() -> System.out.println(inventory.getItems()));
    }

    static CompletableFuture<Item> getItemFromChest(Item item) {
        CompletableFuture<Item> futureItem = CompletableFuture.supplyAsync(() -> {
            inventory.addItem(item);
            return item;
        });
        return futureItem;
    }

    static CompletableFuture<Item> getItemFromShop(Item item) {
        CompletableFuture<Item> futureItem = CompletableFuture.supplyAsync(() -> {
            inventory.addItem(item);
            return item;
        });
        return futureItem;
    }
}
