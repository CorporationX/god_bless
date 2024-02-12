package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String args[]){
        System.out.println();

        List<Item> frodoInventory = new ArrayList<>();
        Character frodo = new Character(frodoInventory);
        InventoryManager inventoryManager = new InventoryManager();

        Item ring = new Item("The One Ring", 1000);
        Item ring2 = new Item("The Second Ring", 10);

        inventoryManager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added"));
        inventoryManager.addItem(frodo, ring2, (item) -> System.out.println(item.getName() + " was added"));

        System.out.println(frodoInventory);
        System.out.println();

        inventoryManager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));

        System.out.println();

        inventoryManager.updateItem(frodo, (item) -> item.getName().equals("The Second Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));

        System.out.println(frodoInventory);
    }
}
