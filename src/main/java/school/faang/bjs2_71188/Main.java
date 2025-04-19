package school.faang.bjs2_71188;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item theRing = new Item("Allmighty Ring", 999);
        Item sword = new Item("Mega Sword", 100);
        InventoryManager manager = new InventoryManager();


        Consumer<Item> itemAddedLog = (item) -> log.info("The item {} has been added to the invetory", item.getName());
        Predicate<Item> itemContainsName = (item) -> item.getName().contains("Ring");
        Predicate<Item> filterItemByName = (item) -> item.getName().equals("Allmighty Ring");
        Function<Item, Item> updataeItem = (item) -> new Item(item.getName(), item.getValue() * 2);

        // Добавляем предмет в инвентарь
        manager.addItem(frodo, theRing, itemAddedLog);
        manager.addItem(frodo, sword, itemAddedLog);
        manager.addItem(frodo, theRing, itemAddedLog);

        // Удаляем предмет из инвентаря
        manager.removeItem(frodo, itemContainsName);

        // Добавляем обратно предмет и обновляем его стоимость
        manager.addItem(frodo, theRing, itemAddedLog);
        manager.updateItem(frodo, filterItemByName, updataeItem);

        // Проверяем результат
        frodo.getInventory().forEach(item -> log.info("{} : {}", item.getName(), item.getValue()));
    }
}
