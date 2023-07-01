package faang.school.godbless;

import faang.school.godbless.lord_of_the_rings.InventoryManager;
import faang.school.godbless.lord_of_the_rings.Item;
import faang.school.godbless.lord_of_the_rings.Character;

public class Application {
    public static void main(String... args) {

        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

// Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));

// Удаляем предмет из инвентаря
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));

// Обновляем предмет в инвентаре
        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));
    }
}
