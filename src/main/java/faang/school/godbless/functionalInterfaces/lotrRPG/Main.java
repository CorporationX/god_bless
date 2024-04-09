package faang.school.godbless.functionalInterfaces.lotrRPG;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        Character gorlum = new Character("Gorlum", new ArrayList<>());

        System.out.println(gorlum.getName() + " inventory at start point:");
        inventoryManager.printInventory(gorlum);

        Consumer<Item> reaction = item -> System.out.println("I found " + item.getName() + "! My... preciousssss.");
        Predicate<Item> deleteCondition = item -> !Objects.equals(item.getValue(), "My preciousssss");
        Predicate<Item> updateCondition = item -> Objects.equals(item.getValue(), "My preciousssss");
        Function<Item, Item> updateFunction = item -> new Item("My... preciousssss ", item.getValue());


        System.out.println("\n" + gorlum.getName() + " found some items:");
        inventoryManager.addItem(gorlum, new Item("The One Ring", "My preciousssss"), reaction);
        inventoryManager.addItem(gorlum, new Item("Broken sword", "Some old broken sword."), reaction);
        inventoryManager.addItem(gorlum, new Item("Frog", "Green frog"), reaction);

        System.out.println("\n" + gorlum.getName() + " inventory at this point:");
        inventoryManager.printInventory(gorlum);


        System.out.println("\n" + gorlum.getName() + " updated some items.");
        inventoryManager.updateItem(gorlum, updateCondition, updateFunction);

        System.out.println("\n" + gorlum.getName() + " inventory at this point:");
        inventoryManager.printInventory(gorlum);

        System.out.println("\n" + gorlum.getName() + " removed unnecessary items.");
        inventoryManager.removeItem(gorlum, deleteCondition);

        System.out.println("\n" + gorlum.getName() + " inventory at this point:");
        inventoryManager.printInventory(gorlum);
    }
}
