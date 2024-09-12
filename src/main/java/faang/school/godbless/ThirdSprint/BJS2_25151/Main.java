package faang.school.godbless.ThirdSprint.BJS2_25151;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        CompletableFuture<Item> itemFromBox = inventory.getFromBox(() -> new Item("sword", 10));
        CompletableFuture<Item> itemFromShop = inventory.getFromShop(() -> new Item("runa", 15));

        inventory.inventoryAutoCombine(itemFromShop, itemFromBox);
        System.out.println(inventory.getItems());
    }
}
