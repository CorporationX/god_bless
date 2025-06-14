package school.faang.module1.bjs2_80336;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class Main {

    public static void main(String[] args) {

        Item ring = new Item("Ring", 1000);
        Item sword = new Item("Sword", 500);
        Item cloak = new Item("Cloak", 300);

        Character frodo = new Character("Frodo", new ArrayList<>());

        InventoryManager manager = new InventoryManager();

        Consumer<Item> addItemAction = item -> log.info("Добавлен предмет: {}", item.getName());
        manager.addItem(frodo, ring, addItemAction);
        manager.addItem(frodo, sword, addItemAction);
        manager.addItem(frodo, cloak, addItemAction);

        Predicate<Item> removeCondition = item -> item.getName().toLowerCase().contains("ring");
        manager.removeItem(frodo, removeCondition);

        log.info("\nПосле удаления предметов с 'ring' в названии:");
        frodo.getInventory().forEach(item -> log.info(item.toString()));

        Predicate<Item> updateCondition = item -> item.getName().equals("Sword");
        Function<Item, Item> updater = item -> new Item(item.getName(), item.getValue() * 2);
        manager.updateItem(frodo, updateCondition, updater);

        log.info("\nПосле обновления:");
        frodo.getInventory().forEach(item -> log.info(item.toString()));
    }
}