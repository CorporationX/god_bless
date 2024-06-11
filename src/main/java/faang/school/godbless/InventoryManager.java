package faang.school.godbless;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<String> applyMessage) {
        if (!character.getInventory().contains(item)) {
            character.getInventory().add(item);
        } else {
            System.out.println(item + " is already exists");
        }
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        for (Item item : character.getInventory()) {
            if (condition.test())
        }
    }
}