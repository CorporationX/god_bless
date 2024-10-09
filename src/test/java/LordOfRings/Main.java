package LordOfRings;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Item sword = new Item("Sword", 1000);
        Item axe = new Item("Axe", 700);
        Item pick = new Item("Pisk", 500);
        Character bilbo = new Character("Bilbo", new ArrayList<>());
        InventoryManager manager = new InventoryManager();

        Consumer<Item> addItemConsumer = item -> System.out.println(item.getName() + " add to inventory");
        Predicate<Item> filterPredicate = item -> item.equals(sword);

        manager.addItem(bilbo, sword, item -> System.out.println(item.getName() + " add to inventory"));
        manager.addItem(bilbo, axe, item -> System.out.println(item.getName() + " add to inventory"));
        manager.addItem(bilbo, sword, addItemConsumer);
        manager.addItem(bilbo, pick, addItemConsumer);
        manager.removeItem(sword, bilbo, item -> item.equals(sword));
        manager.updateItem(bilbo, filterPredicate, x -> x * 2);
        System.out.println();
        System.out.println(sword.getValue());
    }
}
