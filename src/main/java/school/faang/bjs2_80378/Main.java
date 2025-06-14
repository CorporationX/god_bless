package school.faang.bjs2_80378;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();

        Item sword = new Item("sword", 5000);
        Item shield = new Item("shield", 3000);
        Item necklace = new Item("necklace", 1000);

        List<Item> inventory = new ArrayList<>();
        Character nicholas = new Character("Nicholas", inventory);

        inventoryManager.addItem(nicholas.getInventory(), sword, item -> System.out.printf("предмет %s добавлен" +
                " в инвентарь%n", item.getName()));
        inventoryManager.addItem(nicholas.getInventory(), necklace, item -> System.out.printf("предмет %s " +
                "добавлен в инвентарь%n", item.getName()));

        inventoryManager.removeItem(nicholas.getInventory(), item -> item.getName().contains("necklace"));

        inventoryManager.updateItem(nicholas.getInventory(), item -> item.getName().equals("sword"),
                item -> {
                    item.setValue(item.getValue() * 5);
                    return item;
                });

        nicholas.getInventory().forEach(item -> System.out.printf("inventory:%n   item: %s%n   value: %d%n",
                item.getName(), item.getValue()));
    }
}
