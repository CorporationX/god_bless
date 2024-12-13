package school.faang.task_45583;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        Consumer<Item> addAction = (item) -> System.out.println(item.name() + " was added to inventory.");
        manager.addItem(frodo, ring, addAction);

        Predicate<Item> removeCondition = (item) -> item.name().equals("The One Ring");
        manager.removeItem(frodo, removeCondition);
        manager.addItem(frodo, ring, addAction);

        Predicate<Item> updateCondition = (item) -> item.name().equals("The One Ring");
        Function<Item, Item> updateAction = (item) -> new Item(item.name(), item.value() * 2);

        manager.updateItem(frodo, updateCondition, updateAction);

        frodo.getInventory().forEach(item -> System.out.println(item.name() + ": " + item.value()));
    }
}