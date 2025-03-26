package school.faang.rpg.lord_of_the_rings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Character frodo = new Character("Frodo", new ArrayList<>());
        Item ring = new Item("The One Ring", 1000);
        InventoryManager manager = new InventoryManager();
        manager.addItem(frodo, ring, (item)
                -> logger.info("The {} was added to the inventory", item));
        printAllItemsCharacter(frodo);

        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        printAllItemsCharacter(frodo);

        manager.addItem(frodo, ring, (item) -> logger.info("The {} was added again.", item));
        printAllItemsCharacter(frodo);

        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item)
                -> new Item(item.getName(), item.getValue() * 2));
        printAllItemsCharacter(frodo);
    }

    private static void printAllItemsCharacter(Character character) {
        logger.info("All inventory of Character {}", character.getName());
        character.getInventory().forEach(item -> logger.info(item.toString()));
    }
}
