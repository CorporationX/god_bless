package school.faang.bjs270013;

import java.util.ArrayList;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Character shmiga = new Character("Shmiga", new ArrayList<>());
        Item ringlet = new Item("Little cutie", 5000);
        Item ring = new Item("The One Ring", 1000);
        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.printInventory(shmiga);
        inventoryManager.addItem(shmiga, ring, item ->
                System.out.printf("%s added to the inventory\n", item.getName()));
        inventoryManager.addItem(shmiga, ringlet, item ->
                System.out.printf("%s added to the inventory\n", item.getName()));
        inventoryManager.printInventory(shmiga);
        inventoryManager.removeItem(shmiga, item ->
                item.getName().equals("The One Ring"));
        inventoryManager.printInventory(shmiga);

        Function<Item, Item> multiply = item ->
                new Item(item.getName(), item.getValue() * 2);

        inventoryManager.updateItem(shmiga, (item) ->
                item.getName().equals("Little cutie"), multiply);
        inventoryManager.printInventory(shmiga);
    }
}