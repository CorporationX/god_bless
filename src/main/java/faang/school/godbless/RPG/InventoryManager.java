package faang.school.godbless.RPG;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        character.getInventory().removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> function) {
        for (int itemIndex = 0; itemIndex < character.getInventory().size(); itemIndex++) {
            Item currentItem = character.getInventory().get(itemIndex);
            if (condition.test(currentItem)) {
                character.getInventory().remove(currentItem);
                character.getInventory().add(function.apply(currentItem));
            }

        }
    }
}
