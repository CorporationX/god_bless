package school.faang.task_45489;

import lombok.extern.slf4j.Slf4j;
import school.faang.task_45489.model.Character;
import school.faang.task_45489.model.Item;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        InventoryManager manager = new InventoryManager();

        addItemsAndPrint(frodo, manager);
        removeItemAndPrint(frodo, manager);
        updateItemAndPrint(frodo, manager);
    }

    private static void addItemsAndPrint(Character character, InventoryManager manager) {
        manager.addItem(Item.RING, character, (item) -> {
            log.info("A {} item has been added to {} inventory", item.name(), character.getName());
        });

        manager.addItem(Item.SWORD, character, (item) -> {
            log.info("A {} item has been added to {} inventory", item.name(), character.getName());
        });

        log.info("Frodo inventory: {}", character.getInventory());
    }

    private static void removeItemAndPrint(Character character, InventoryManager manager) {
        manager.removeItem(character, (item) -> item.getValue() > 1300);
        log.info(character.getInventory().toString());
    }

    private static void updateItemAndPrint(Character character, InventoryManager manager) {
        manager.updateItem(
                character,
                (item) -> item.getValue() > 100,
                (item) -> Item.SWORD
        );
        log.info(character.getInventory().toString());
    }
}
