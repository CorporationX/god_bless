package school.faang.lordoftherings;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        try {
            Character commonCharacter = new Character("Bob");
            List<Item> items = new ArrayList<>();

            items.add(new Item("Ring", 19, Rareness.TRASH));
            items.add(new Item("Necklace", 32, Rareness.TRASH));
            items.add(new Item("Sword", 500, Rareness.RARE));
            items.add(new Item("Axe", 250, Rareness.COMMON));
            items.add(new Item("Shield", 300, Rareness.RARE));
            items.add(new Item("Eye of dark", 3000, Rareness.LEGENDARY));

            InventoryManager inventoryManager = new InventoryManager();

            items.forEach(item -> inventoryManager.addItem(commonCharacter, item, currentItem ->
                    log.info("{} got a new item: {}", commonCharacter.getName(), currentItem.getName())));
            printInventory(commonCharacter);

            inventoryManager.removeItem(commonCharacter, item -> item.getRareness() == Rareness.TRASH);
            printInventory(commonCharacter);

            inventoryManager.updateItem(commonCharacter, item -> item.getValue() >= 500,
                    item -> new Item(item.getName(), item.getValue() * 2, item.getRareness()));
            printInventory(commonCharacter);
        } catch (Exception exception) {
            log.error(exception.getMessage());
        }
    }

    private static void printInventory(Character character) {
        character.getInventory().forEach(item ->
                log.info("{} - {} - {}", item.getName(), item.getValue(), item.getRareness()));
    }
}
