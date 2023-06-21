package faang.school.godbless.rpg;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>(){{
            add(new Item("Sword", 1));
        }};
        Character frodo = new Character("Frodo", items);
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

// Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));

// Удаляем предмет из инвентаря
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));

// Обновляем предмет в инвентаре
        manager.updateItem(frodo, (item) -> item.getName().equals("Sword"), (item) -> new Item(item.getName(), item.getValue() + 1));

        System.out.println(frodo.getInventory());
    }
}
