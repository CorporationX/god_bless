package faang.school.godbless.LOTRRPG2588;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, String message, Consumer<String> notification) {
        if (character.getInventory() != null) {
            character.getInventory().add(item);
        } else {
            character.setInventory(new ArrayList<>(List.of(item)));
        }
        notification.accept(message);
    }

    public void removeItem(Character character, Item item, Predicate<Item> condition) {
        if (character.getInventory() != null) {
            if (condition.test(item)) {
                character.getInventory().remove(item);
            }
        }
    }

    public void updateItem(Character character, Item item, Predicate<Item> condition1, Predicate<Item> condition2, Function<Item, Item> update) {
        if (condition1.test(item) && condition2.test(item)) {
            Item updated = update.apply(item);
            character.getInventory().remove(item);
            character.getInventory().add(updated);
        }
    }
}