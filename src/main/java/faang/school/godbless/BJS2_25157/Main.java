package faang.school.godbless.BJS2_25157;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.addItem(new Item("Sword", 50));
        inventory.addItem(new Item("Shield", 30));
        inventory.addItem(new Item("Helmet", 20));
        inventory.addItem(new Item("Armor", 40));

        CompletableFuture<Item> combinedItem = inventory.combineItems(inventory.getFirstItem("Sword"), inventory.getSecondItem("Armor"));

        combinedItem.thenAccept(item -> {
            System.out.println("Combined Item: " + item.getName() + ", Power: " + item.getPower());
        }).join();

        inventory.getItems().forEach(item -> System.out.println(item.getName()));
    }
}
