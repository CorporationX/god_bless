package school.faang.lambda.lord;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, BiConsumer<Character, Item> addItem) {
        addItem.accept(character, item);
    }

    public void removeItem(Character character, Predicate<Item> deleteCondition) {
        character.getInventory().removeIf(deleteCondition);
    }

    public void updateItem(Character character,
                           Predicate<Item> condition,
                           Consumer<Item> updateAction) {
        character.getInventory().stream().filter(condition).forEach(updateAction);
    }
}