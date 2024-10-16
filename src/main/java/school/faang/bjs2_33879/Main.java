package school.faang.bjs2_33879;

import school.faang.bjs2_33879.model.Item;
import school.faang.bjs2_33879.model.Character;
import school.faang.bjs2_33879.service.InventoryManager;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        Character alaric = new Character("Alaric");
        Item amulet = new Item("Amulet of the Fallen King", 1500);

        Consumer<Item> additionalAction = System.out::println;
        inventoryManager.addItem(alaric, amulet, additionalAction);

        Predicate<Item> updCondition = item -> item.getValue() < 2000;
        Function<Item, Item> updateAction = item -> new Item(item.getName(), item.getValue() * 2);
        inventoryManager.updateItem(alaric, updCondition, updateAction);
        System.out.println(alaric.getInventory());

        Predicate<Item> removeCondition = item -> item.getValue() > 2000;
        List<Item> inventory = alaric.getInventory();
        Item amuletForRemove = inventory.get(0);
        inventoryManager.removeItem(alaric, amuletForRemove, removeCondition);
        System.out.println(alaric.getInventory());
    }
}
