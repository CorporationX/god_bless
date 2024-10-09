package bjs2_33388;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        Character character = new Character(new ArrayList<>());
        InventoryManager inventoryManager = new InventoryManager();

        Item ring = new Item("The One Ring", 1000);
        Item invisibilityCloak = new Item("Invisibility Cloak", 5000);

        Consumer<Item> addItemEvent = (item) -> System.out.println(item.getName() +
                " has been added to the inventory");
        Predicate<Item> deleteItemCondition = (item) -> item.getValue() < 2000;
        Predicate<Item> updateItemCondition = (item) -> item.getName().startsWith("Invis");
        Consumer<Item> updateItem = (item) -> item.setValue(item.getValue() * 2);

        inventoryManager.addItem(character, ring, addItemEvent);
        inventoryManager.addItem(character, invisibilityCloak, addItemEvent);
        inventoryManager.removeItem(character, deleteItemCondition);
        inventoryManager.updateItem(character, updateItemCondition, updateItem);

        character.getInventory().forEach((item) -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
