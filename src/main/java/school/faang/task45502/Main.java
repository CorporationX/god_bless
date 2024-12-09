package school.faang.task45502;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("Ring", 1000);
        Item sword = new Item("Sword", 500);

        InventoryManager inventoryManager = new InventoryManager();

        Consumer<Item> addItem = item -> System.out.println("Добавлен предмет: " + item.getName());

        inventoryManager.addItem(frodo, ring, addItem);
        inventoryManager.addItem(frodo, sword, addItem);

        List<Item> inventory = frodo.getInventory();

        inventory.forEach(System.out::println);

        Predicate<Item> deleteCondition = item -> item.getName().equals("Ring");
        Predicate<Item> findCondition = item -> item.getValue() == 500;
        Consumer<Item> updateCondition = item -> item.setValue(item.getValue() * 20);

        inventoryManager.removeItem(frodo, deleteCondition);
        inventoryManager.updateItem(frodo, findCondition, updateCondition);
        inventory.forEach(System.out::println);
    }
}
