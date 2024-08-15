package faang.school.godbless.lordOfTheRings;

import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Character character = new Character("Dodo");
        Item apple = new Item("apple", 5);
        Item knife = new Item("knife", 1);

        InventoryManager inventoryManager = new InventoryManager();

        Consumer<String> consumer = s -> System.out.println(s + " was added to inventory");

        Function<Item, Item> itemHandler = item -> {
            item.setValue(item.getValue() + 1);
            return item;
        };

        System.out.println(character.getInventory());
        inventoryManager.addItem(character, apple, consumer);
        inventoryManager.addItem(character, knife, consumer);
        System.out.println(character.getInventory());

        inventoryManager.removeItem(character, item -> item.getName().equalsIgnoreCase(apple.getName()));
        System.out.println(character.getInventory());

        inventoryManager.updateItem(character,
                item -> item.getName().equalsIgnoreCase(knife.getName()),
                itemHandler);
        System.out.println(character.getInventory());

        inventoryManager.updateItem(character,
                item -> item.getName().equalsIgnoreCase(apple.getName()),
                itemHandler);
        System.out.println(character.getInventory());
    }
}
