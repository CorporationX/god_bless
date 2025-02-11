package school.faang.lordoftherings;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String NEW_ITEM = " got a new item: ";

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
                    System.out.println(commonCharacter.getName() + NEW_ITEM + currentItem.getName())));
            printInventory(commonCharacter);

            inventoryManager.removeItem(commonCharacter, item -> item.getRareness() == Rareness.TRASH);
            printInventory(commonCharacter);

            inventoryManager.updateItem(commonCharacter, item -> item.getValue() >= 500,
                    item -> new Item(item.getName(), item.getValue() * 2, item.getRareness()));
            printInventory(commonCharacter);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void printInventory(Character character) {
        character.getInventory().forEach(item ->
                System.out.println(item.getName() + " - " + item.getValue() + " - " + item.getRareness()));
        System.out.println();
    }
}
