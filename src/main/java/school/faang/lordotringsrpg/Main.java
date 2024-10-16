package school.faang.lordotringsrpg;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // Create a character
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        // Create an instance of InventoryManager
        InventoryManager manager = new InventoryManager();

        // Consumer to print a message when an item is added
        Consumer<Item> printAddMessage = (item) -> System.out.println(item.getName() + " was added to the inventory.");

        // Add the ring to Frodo's inventory
        manager.addItem(frodo, ring, printAddMessage);

        // Predicate to find and remove the ring by name
        Predicate<Item> isRing = (item) -> item.getName().equals("The One Ring");

        // Remove the ring from the inventory
        manager.removeItem(frodo, isRing);

        // Add the ring back to the inventory and print a message
        manager.addItem(frodo, ring, printAddMessage);

        // Function to double the value of an item
        Function<Item, Item> doubleValue = (item) -> new Item(item.getName(), item.getValue() * 2);

        // Update the ring's value if it matches the condition
        manager.updateItem(frodo, isRing, doubleValue);

        // Print the inventory to check the results
        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}

