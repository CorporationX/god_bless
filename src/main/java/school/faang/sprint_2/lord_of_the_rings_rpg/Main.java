package school.faang.sprint_2.lord_of_the_rings_rpg;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Slf4j
public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        List<Item> items = new ArrayList<>();
        items.add(new Item("Sword", 120));
        items.add(new Item("Stick", 10));
        Character character = new Character("Frodo", items);

        showInventory(character, inventoryManager);

        Item stone = new Item("Stone", 20);
        inventoryManager.addItem(character, stone);

        showInventory(character, inventoryManager);

        Predicate<Item> predicate = item -> item.getName().equals("Stone");
        Consumer<Item> consumer = item -> item.setValue(item.getValue() * 2);
        inventoryManager.updateItem(character, predicate, consumer);
        showInventory(character, inventoryManager);

    }

    public static void showInventory(Character character, InventoryManager inventoryManager) {
        inventoryManager.removeItem(character, item -> item.getName().equals("Sword"));
        for (Item item : character.getInventory()) {
            log.info("Character {} have {} with price {}", character.getName(), item.getName(), item.getValue());
        }
    }

}
