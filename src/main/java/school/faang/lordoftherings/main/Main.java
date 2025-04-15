package school.faang.lordoftherings.main;

import lombok.extern.slf4j.Slf4j;
import school.faang.lordoftherings.model.Character;
import school.faang.lordoftherings.model.Item;
import school.faang.lordoftherings.service.InventoryManager;

import java.util.ArrayList;

@Slf4j
public class Main {

    public static void main(String[] args) {
        Character frodo = new Character("Frodo", new ArrayList<>());
        Item ring = new Item("Ring", 2000);
        Item food = new Item("Food", 1200);
        Item rope = new Item("Rope", 800);
        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item -> log.info("{} added in inventory", item)));
        manager.addItem(frodo, food, (item -> log.info("{} added in inventory", item)));
        manager.addItem(frodo, rope, (item -> log.info("{} added in inventory", item)));

        manager.removeItem(frodo, item -> item.getName().toLowerCase().contains("rope"));
        manager.updateItem(
                frodo,
                item -> item.getName().equalsIgnoreCase("food"),
                item -> new Item(item.getName(), item.getValue() * 2)
        );
        frodo.getInventory().forEach(item -> log.info("inventory item: {}", item));
    }
}