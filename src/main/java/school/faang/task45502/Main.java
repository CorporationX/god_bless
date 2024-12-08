package school.faang.task45502;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {

    private static Consumer<Item> addItem;
    private static Predicate<Item> deleteCondition;
    private static Predicate<Item> findCondition;
    private static Consumer<Item> updateCondition;

    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("Ring", 1000);
        Item sword = new Item("Sword", 500);

        InventoryManager inventoryManager = new InventoryManager();
        generateInterfaces();

        inventoryManager.addItem(frodo, ring, addItem);
        inventoryManager.addItem(frodo, sword, addItem);

        List<Item> inventory = frodo.getInventory();

        inventory.forEach(System.out::println);

        inventoryManager.removeItem(frodo, deleteCondition);

        inventoryManager.updateItem(frodo, findCondition, updateCondition);
        inventory.forEach(System.out::println);
    }

    private static void generateInterfaces() {
        addItem = item -> System.out.println("Добавлен предмет: " + item.getName());
        deleteCondition = item -> item.getName().equals("Ring");
        findCondition = item -> item.getValue() == 500;
        updateCondition = item -> item.setValue(item.getValue() * 20);
    }
}
